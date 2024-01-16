import json
from pathlib import Path
import time
import numpy as np
import hashlib
import os
import pickle
import sys
import logging
from .utils import (filter_code, highlight_overlap, get_copied_slices,
                    get_document_fingerprints, find_fingerprint_overlap)
import matplotlib.pyplot as plt
import webbrowser
import pkg_resources
from jinja2 import Template
from tqdm import tqdm
import shutil
from .fingerprint import Fingerprint

#tokenization and filtering replaces variable names with V,
# function names with F, object names with O, and strings with S
# so the threshold should be lower than you would expect from the
# original code.

class PlagDetector:
    """
    Searches and compares input files and calculates plagiarism similarilty between them
    
    Parameters
    ----------
    config: dict
        Contains the configuration parameters. 
    extensions: list
        File extensions of the code files
    skeleton_dir: list
        Contains skelton files/code. Any matches found between the code files and skeleton dirs will not be taken into account.
    noise_value: int
        Smallest sequence of matching characters between two files
    guarantee_value: int
        Smallest sequence of matching characters between two files guaranteed to detect a match. Must be greater than or equal to noise.
    display_thres: float
        Similarity percentage cutoff for displaying similar files.
    """
    
    def __init__(self, config=None):
        
        # get extensions and check
        self.extensions = config["extensions"]
        if not isinstance(self.extensions, list):
            raise TypeError("Extensions must be a string")

        # get skeleton dirs and check (if any)
        if "skeleton_dir" in config:
            self.skeleton_dir = config["skeleton_dir"]
            if not isinstance(self.skeleton_dir, list):
                raise TypeError("Skeleton directories must be a list")
        
        # get noise value and check
        self.noise_value = config["noise_value"]
        if not isinstance(self.guarantee_value, int):
            raise TypeError("Noise threshold value must be an integer")
        
        # get gurantee value and check
        self.guarantee_value = config["guarantee_value"]
        if not isinstance(self.guarantee_value, int):
            raise TypeError("Guarantee threshold value must be an integer")

        if self.guarantee_value < self.noise_value:
            raise ValueError("Guarantee threshold must be greater than or "
                             "equal to noise threshold")
        
        # get display threshold value and check
        self.display_thres = config["display_thres"]
        if self.display_thres > 1 or self.display_thres < 0:
            raise ValueError("Display threshold must be between 0 and 1")
    
        # set window size
        self.window_size = self.guarantee_t - self.noise_t + 1

        # extract all the files
        self.test_files = self.get_files(["Test"], self.extensions)
        self.ref_files = self.test_files
        self.skeleton_files = self.get_files(self.skeleton_dir, self.extensions)

        # stores overlap between files
        self.similarity_matrix = np.array([])
        # stores location of copied code
        self.token_overlap_matrix = np.array([])
        # stores token overlap information
        self.slice_matrix = np.array([])
 
    def get_files(self, dirs, extensions, unique=True): 
        """
        Search and return list of files from provided directory matching the extensions
        """
        fileList = []
        # recurvisely iterate through the directories and files and ensure match the given extensions
        for dir in dirs:
            for ext in extensions:
                files = []
                # get files that match given extensions
                if ext == "*":
                    matched_contents = Path(dir).rglob("*")
                else:
                    matched_contents = Path(dir).rglob("*." + ext.lstrip("."))
                
                for f in matched_contents:
                    if f.is_file():
                        files.push(str(f))

                # check for empty dirs
                if len(files) == 0:
                    logging.warning("No files found in " + dir)
                
                # append the files
                fileList.extend(files)

        return set(fileList)

    def run(self):
        """
        User facing code that commences the palgiarism detection process
        """
        # check for empty dirs
        if len(self.test_files) == 0 or len(self.ref_files) == 0:
            logging.error("No files were found in Test directory")
            return

        # run the algorithm
        self.comparison_loop()
        # generate report to display results
        self.generate_report()

    def get_skeleton_hashes(self):
        """
        Returns set of unique k-gram hashes of the skeleton code
        """
        skeleton_hashes = []
        for file in self.skeleton_files:
            try:
                with open(file) as skeleton_fp:
                    skeleton = skeleton_fp.read()
            except UnicodeDecodeError:
                logging.warning(f"Skipping {file}: file not ASCII text")
                continue
            fingerprint = Fingerprint(file, self.noise_t, 1, language=self.force_language)
            skeleton_hashes.extend(fingerprint.hashes)

        return np.unique(np.array(skeleton_hashes))

    def preprocess_code(self, file_list):
        skelton_hashes = self.get_skeleton_hashes()

        file_data = {}
        for code_f in tqdm(file_list, bar_format= '   {l_bar}{bar}{r_bar}',
                disable=False):
            try:
                file_data[code_f] = Fingerprint(code_f, self.noise_t, self.window_size, skelton_hashes, self.force_language)

            except UnicodeDecodeError:
                logging.warning(f"Skipping {code_f}: file not ASCII text")
                continue

        return file_data

    def comparison_loop(self):
        """
        Does code comparision between the provided input files
        """
        start_time = time.time()
        print("  0.00: Generating file fingerprints")
        
        # store test files as list
        self.test_files_list = sorted(list(self.test_files))
        self.all_files = self.test_files_list
        
        self.file_data = self.preprocess_code(self.all_files)

        # stores overlap between files
        self.similarity_matrix = np.array([])
        # stores location of copied code
        self.token_overlap_matrix = np.array([])
        # stores token overlap information
        self.slice_matrix = np.array([])

        # stores overlap between files
        self.similarity_matrix = np.full((len(self.all_files), len(self.all_files)), -1, dtype=np.float64)
        # stores location of copied code
        self.token_overlap_matrix = np.full((len(self.all_files), len(self.all_files)), -1)
        # stores token overlap information
        self.slice_matrix = [[np.array([]) for _ in range(len(self.all_files))] for _ in range(len(self.all_files))]

        print(f"{time.time()-start_time:6.2f}: Beginning code comparison")

        for i, test_f in enumerate(tqdm(self.test_files_list,
                bar_format= '   {l_bar}{bar}{r_bar}')):
            for j, ref_f in enumerate(self.all_files):
                if test_f not in self.file_data or ref_f not in self.file_data:
                    continue
                elif test_f == ref_f:
                    continue
                elif self.similarity_matrix[i,j] != -1:
                    continue
                elif (self.all_files[i] not in self.test_files or
                      self.all_files[j] not in self.ref_files):
                    continue

                overlap, (sim1,sim2), (slices1,slices2) = self.compare_files(
                    self.file_data[test_f], self.file_data[ref_f])

                self.similarity_matrix[i,j] = sim1
                self.slice_matrix[i][j] = [slices1, slices2]
                self.similarity_matrix[j,i] = sim2
                self.slice_matrix[j][i] = [slices2,slices1]

                self.token_overlap_matrix[i,j] = overlap
                self.token_overlap_matrix[j,i] = overlap

       
        print(f"{time.time()-start_time:6.2f}: Code comparison completed")


    def compare_files(self, file1_data, file2_data):
        """
        Compute overlap between two Fingerprint objects.
        Returns number of overlapping tokens, tuple containing overlap percentage and another tuple containing copied slices for each unfiltered code file.
        
        Parameters
        ----------
        file1_data : Fingerprint object 
            Fingerprint object of file 1.
        file2_data : Fingerprint object
            Fingerprint object of file 2.

        Returns
        -------
        token_overlap : int
            Number of overlapping tokens between the two files.
        similarities : tuple of 2 ints
            Contains overlap percentage
            For both files: number of overlapping tokens divided by the
            total number of tokens in that file.
        slices : tuple of 2 2xN int arrays
            For both files: locations of copied code in the unfiltered
            text. Dimension 0 contains slice starts, dimension 1 contains
            slice ends.
        """
        if file1_data.k_gram_size != file2_data.k_gram_size:
            raise ValueError("Code fingerprints must use the same noise threshold")
        
        # find indexes of overlapping values between two lists of hashes
        overlap, ol_idx1, ol_idx2 = np.intersect1d(file1_data.hashes, file2_data.hashes,
            return_indices=True, assume_unique=True)
        idx1 = file1_data.hash_idx[ol_idx1] # first hash list
        idx2 = file2_data.hash_idx[ol_idx2] # second hash list

        slices1 = self.get_copied_slices(idx1, file1_data.k_gram_size)
        slices2 = self.get_copied_slices(idx2, file2_data.k_gram_size)
        if len(slices1[0]) == 0:
            return 0, (0,0), (np.array([]), np.array([]))

        token_overlap1 = np.sum(slices1[1] - slices1[0])
        token_overlap2 = np.sum(slices2[1] - slices2[0])

        if len(file1_data.filtered_code) > 0:
            similarity1 = token_overlap1 / len(file1_data.filtered_code)
        else:
            similarity1 = 0
        if len(file2_data.filtered_code) > 0:
            similarity2 = token_overlap2 / len(file2_data.filtered_code)
        else:
            similarity2 = 0

        if len(file1_data.offsets) > 0:
            slices1 += file1_data.offsets[:,1][np.clip(
                np.searchsorted(file1_data.offsets[:,0], slices1),
                0, file1_data.offsets.shape[0] - 1)]
        if len(file2_data.offsets) > 0:
            slices2 += file2_data.offsets[:,1][np.clip(
                np.searchsorted(file2_data.offsets[:,0], slices2),
                0, file2_data.offsets.shape[0] - 1)]

        return token_overlap1, (similarity1,similarity2), (slices1,slices2)
    

    def get_copied_slices(self, idx, k_gram_size):
        """
        Generates list of slices where the copied code begins and ends.
        Returns a 2D array where first dimension is slice start locations & second dimension is slice end location.
        """

        if len(idx) == 0:
            return np.array([[],[]])

        # determine the gaps between slices
        sorted_idx = np.sort(idx)
        next_idx = np.concatenate([sorted_idx[1:], [0]])
        skips = np.where(next_idx - sorted_idx > k_gram_size - 1)[0]

        # use the elements around the gaps to compute slice start/ends
        slice_starts = np.concatenate([[sorted_idx[0]], sorted_idx[skips + 1]])
        slice_ends = np.concatenate([sorted_idx[skips] + k_gram_size, [sorted_idx[-1] + k_gram_size]])

        return np.array([slice_starts, slice_ends])

    def generate_report(self, dir="Output", page_name="Output", output_mode="save"):
        """
        Generates an html report and lists files with similarity above threshold with copied code fragments highlighted.
        """
        if len(self.similarity_matrix) == 0:
            logging.error("Cannot generate report: no files compared")
            return

        code_list = self.get_copied_code_list()
        data_dir = pkg_resources.resource_filename('data/')

        # render template with jinja and save as html
        with open(data_dir + "report.html") as template_fp:
            template = Template(template_fp.read())

        flagged = self.similarity_matrix > self.display_t
        flagged_file_count = np.sum(np.any(flagged, axis=1))

        output = template.render(test_count=len(self.test_files),
                                 compare_count=len(self.ref_files),
                                 flagged_file_count=flagged_file_count,
                                 code_list=code_list,
                                 style_path="style/style.css")

        if output_mode == "save":
            with open(f"{dir}/{page_name}.html", "w") as report_f:
                report_f.write(output)

            if not os.path.exists(f"{dir}/style/"):
                os.makedirs(f"{dir}/style/")
            shutil.copy(data_dir + "style.css", f"{dir}/style/style.css")

            if not self.silent:
                print(f"Output saved to {dir}/{page_name}.html")
            if self.autoopen:
                webbrowser.open('file://'
                                + os.path.realpath(f"{dir}/{page_name}.html"))
        elif output_mode == "return":
            return output
        else:
            raise ValueError("output_mode not supported")

    def get_copied_code_list(self):
        """
        Retrieves list of copied code to be dislpayed on the output report.
        Returns a list of tuples containing similiarity score, filenames and highlighted code.
        """
        if len(self.similarity_matrix) == 0:
            logging.error("Cannot generate code list: no files compared")
            return []
        x,y = np.where(self.similarity_matrix > self.display_t)

        code_list = []
        selected_pairs = set([])
        for idx in range(len(x)):
            test_f = self.all_files[x[idx]]
            ref_f = self.all_files[y[idx]]
            if test_f + ref_f in selected_pairs:
                continue

            selected_pairs.add(test_f + ref_f)
            selected_pairs.add(ref_f + test_f)
            test_sim = self.similarity_matrix[x[idx], y[idx]]
            ref_sim = self.similarity_matrix[y[idx], x[idx]]
            slices_test = self.slice_matrix[x[idx]][y[idx]][0]
            slices_ref = self.slice_matrix[x[idx]][y[idx]][1]

            if self.truncate:
                truncate = 10
            else:
                truncate = -1
            hl_code_1, _ = highlight_overlap(
                self.file_data[test_f].raw_code, slices_test,
                "<span class='highlight-red'>", "</span>",
                truncate=truncate, escape_html=True)
            hl_code_2, _ = highlight_overlap(
                self.file_data[ref_f].raw_code, slices_ref,
                "<span class='highlight-green'>", "</span>",
                truncate=truncate, escape_html=True)
            overlap = self.token_overlap_matrix[x[idx], y[idx]]

            code_list.append([test_sim, ref_sim, test_f, ref_f,
                              hl_code_1, hl_code_2, overlap])

        code_list.sort(key=lambda x: -x[0])
        return code_list

    def highlight_overlap(self, doc, slices, left_hl, right_hl,
                        truncate=-1, escape_html=False):
        """
        Highlights copied code in report.
        Returns document annoted with the highlight strings as well as
        the percentage of code which was highlighted.
        """
        hl_percent = np.sum(slices[1] - slices[0])/len(doc)

        new_doc = ""
        current_idx = 0
        for slice_idx in range(slices.shape[1]):
            start_idx = slices[0,slice_idx]
            end_idx = slices[1,slice_idx]

            if escape_html:
                pre_highlight = str(escape(doc[current_idx:start_idx]))
                highlighted = left_hl+str(escape(doc[start_idx:end_idx]))+right_hl
            else:
                pre_highlight = doc[current_idx:start_idx]
                highlighted = left_hl + doc[start_idx:end_idx] + right_hl

            if truncate >= 0:
                lines = pre_highlight.split("\n")
                if slice_idx != 0 and len(lines) > truncate*2:
                    pre_highlight = ("\n".join(lines[:truncate+1]) + "\n\n...\n\n"
                                    + "\n".join(lines[-truncate - 1:]))
                elif len(lines) > truncate:
                    pre_highlight = "\n".join(lines[-truncate - 1:])

            new_doc += pre_highlight + highlighted
            current_idx = end_idx

        if escape_html:
            post_highlight = str(escape(doc[current_idx:]))
        else:
            post_highlight = doc[current_idx:]

        if truncate >= 0:
            lines = post_highlight.split("\n")
            if len(lines) > truncate:
                post_highlight = "\n".join(lines[:truncate])
        new_doc += post_highlight

        return new_doc, hl_percent

