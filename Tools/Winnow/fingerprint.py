import pygments.util
from pygments import lexers, token
import numpy as np
import logging

class Fingerprint:
    """
    Class to tokenize, filter, fingerprint and then apply winnnowing algorithm.
    Keep information about fingerprint and token indexes (for code highlighting)
    
    Parameters
    ----------
    filename: str
        File from which fingerprints are obtained
    k_gram_size: int
        K-grams length of fingerprints
    winnow_size: int
        Window size for winnowing
    skeleton_fingerprints: array
        List of skeleton fingerprints obtained from skeleton file (if provided)
        These fingerprints are ignored from code's hash list
    language: str
        If provided tokenizer will use this. If not, language is guessed from file extensions of code files.
    """
    def __init__(self, filename, k_gram_size, winnow_size, skeleton_fingerprints=[], language=None):
        
        # obtain the code contents from given file
        with open(filename) as code_fp:
            code = code_fp.read()
         
        # obtain filtered code
        filtered_code, offsets = self.filter_code(code, filename, language)
        
        # obtain fingerprint hashes and indexes of those fingerprints
        hashes, idx = self.extract_fingerprints(filtered_code, k_gram_size, winnow_size, skeleton_fingerprints)

        # stores name of provided file
        self.filename = filename
        
        # stores unfiltered code 
        self.raw_code = code

        # stores filtered code after tokenization and filtering
        self.filtered_code = filtered_code

        # cumulative number of characters removed during filtering at each index of the filtered code. 
        # Used for translating locations in the filtered code to locations in the unfiltered code.
        self.offsets = offsets

        # List of fingerprints extracted from the filtered code
        self.hashes = hashes

        # List of indexes of the selected fingerprints. 
        # Used for translating hash indexes to indexes in the filtered code.
        self.hash_idx = idx
        
        self.k_gram_size = k_gram_size
        
    def filter_code(self, code, filename, language=None):
        """
        Tokenize and filter provided code file.
        Variable names are replaced with "var"
        Object names are replaced with "obj"
        Function names are replaced with "funct"
        String names are replaced with "str"

        Returns filtered document & list of offsets indicating how many characters were removed at each index of resulting document. 
        Used to highlight original code by using obtained results on filtered code       
        """
        
        try:
            # if language is provided
            if language is not None:
                lexer = lexers.get_lexer_by_name(language)
            else:
                lexer = lexers.get_lexer_for_filename(filename)
            
            # process the text and return tokens
            tokens = lexer.get_tokens(code)

        except pygments.util.ClassNotFound:
            logging.warning(f"{filename} not tokenized: unknown file extension")
            return code, np.array([])

        if lexer == pygments.lexers.TextLexer:
            logging.warning(f"did not tokenize plaintext file {filename}")
            return code, np.array([])

        # to store the tokenized code
        tokenized_code = ""
        # to calculate the offset in the original code
        offset = 0
        # to store the offset in the tokenized and original code
        offsets = [[0,0]]
        
        # tokenization process
        for t in tokens:
            # for function name
            if t[0] in token.Name.Function:
                tokenized_code += "funct"
                offsets.append([len(tokenized_code) - 1, offset])
                offset += len(t[1]) - 1
            # for variable
            elif t[0] == token.Name:
                tokenized_code += "var"
                offsets.append([len(tokenized_code) - 1, offset])
                offset += len(t[1]) - 1
            # for text or comment
            elif t[0] == token.Text or t[0] in token.Comment:
                offsets.append([len(tokenized_code) - 1, offset])
                offset += len(t[1])
            # for objects
            elif t[0] in token.Name.Class:
                tokenized_code += "obj"
                offsets.append([len(tokenized_code) - 1, len(t[1]) - 1])
                offset += len(t[1]) - 1
            # for strings
            elif t[0] in token.Literal.String:
                if t[1] == "'" or t[1] == '"':
                    tokenized_code += '"'
                else:
                    tokenized_code += "str"
                    offsets.append([len(tokenized_code) - 1, offset])
                    offset += len(t[1]) - 1
            else:
                tokenized_code += t[1]
        return tokenized_code, np.array(offsets)

    def extract_fingerprints(self, code, k_gram_size, winnow_size, skeleton_fingerprints=[]):
        """
        Computes all k-gram hashes and then reduces unwanted ones by winnowing.
        Removes any skeleton hashes from the winnowed list.
        Returns the remaining hashes and their indexes in the original list
        """
        hashes, idx = self.hash_selector(self.hashed_kgrams(code, k_gram_size=k_gram_size), winnow_size=winnow_size)
        if len(skeleton_fingerprints) > 0:
            _, overlap_idx, _ = np.intersect1d(hashes, skeleton_fingerprints,
                                            return_indices=True,
                                            assume_unique=True)
            idx = np.delete(idx, overlap_idx)
            hashes = np.delete(hashes, overlap_idx)
        return hashes, idx
    
    def hashed_kgrams(self, string, k_gram_size):
        """
        Return hashes of all k-grams in a string
        """
        hashes = [hash(string[offset:offset + k_gram_size])
                for offset in range(len(string) - k_gram_size + 1)]
        return np.array(hashes)

    def hash_selector(self, hashes, winnow_size, remove_duplicates=True):
        """
        Returns list of hashes and indexes of those hashes
        """
        if winnow_size == 1:
            # select all hashes
            selected_hashes = hashes
            selected_idx = np.arange(len(hashes))
        else:
            # remove by winnowing algorithm
            selected_idx = self.winnow(hashes, winnow_size)
            selected_hashes = hashes[selected_idx]

        # remove duplicates
        if remove_duplicates:
            selected_hashes, unique_idx = np.unique(selected_hashes, return_index=True)
            selected_idx = selected_idx[unique_idx]

        return selected_hashes, selected_idx
    
    def winnow(self, hashes, winnow_size):
        """
        Winnowing algorithm.
        """
        selected_idx = []
        buffer = np.full(winnow_size, np.inf)
        
        # right end of window
        right_end = 0 
        
        # index of minimum hash
        min_idx = 0 

        for hash_idx, hash in enumerate(hashes):
            right_end = (right_end + 1) % winnow_size
            buffer[right_end] = hash

            if min_idx == right_end:
                i = (right_end - 1) % winnow_size
                while i != right_end:
                    if buffer[i] < buffer[min_idx]:
                        min_idx = i
                    i = (i - 1) % winnow_size

                selected_idx.append(hash_idx - ((right_end - min_idx) % winnow_size))
            else:
                if buffer[right_end] < buffer[min_idx]:
                    min_idx = right_end
                    selected_idx.append(hash_idx)

        return np.array(selected_idx, dtype=np.int64)
