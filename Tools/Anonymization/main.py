import sys
import re
import hashlib, uuid
from pathlib import Path
from typing import Iterable, Pattern, Callable, List, Any
import re
import argparse
import logging 
import os
from os.path import join, getsize, isfile

__version__ = "0.1"

Regex_Dict = {
    "mac": r'(?:[0-9a-fA-F]:?){12}',
    "phone": r'[6|8|9]\d{7}',
    "email": r'[\w\.-]+@[\w\.-]+\.\w+',
    "url": r'(https?:\/\/(?:www\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\.[^\s]{2,}|www\.[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\.[^\s]{2,}|https?:\/\/(?:www\.|(?!www))[a-zA-Z0-9]+\.[^\s]{2,}|www\.[a-zA-Z0-9]+\.[^\s]{2,})',
    "ipv4": r'(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)(?:\.)){3}(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?))',
    "ipv6": r'(?:(?:[0-9a-fA-F]{1,4}:){7,7}[0-9a-fA-F]{1,4}|(?:[0-9a-fA-F]{1,4}:){1,7}:|(?:[0-9a-fA-F]{1,4}:){1,6}:[0-9a-fA-F]{1,4}|(?:[0-9a-fA-F]{1,4}:){1,5}(?::[0-9a-fA-F]{1,4}){1,2}|(?:[0-9a-fA-F]{1,4}:){1,4}(?::[0-9a-fA-F]{1,4}){1,3}|(?:[0-9a-fA-F]{1,4}:){1,3}(?::[0-9a-fA-F]{1,4}){1,4}|(?:[0-9a-fA-F]{1,4}:){1,2}(?::[0-9a-fA-F]{1,4}){1,5}|[0-9a-fA-F]{1,4}:(?:(?::[0-9a-fA-F]{1,4}){1,6})|:(?:(?::[0-9a-fA-F]{1,4}){1,7}|:)|fe80:(?::[0-9a-fA-F]{0,4}){0,4}%[0-9a-zA-Z]{1,}|::(?:ffff(?::0{1,4}){0,1}:){0,1}(?:(?:25[0-5]|(?:2[0-4]|1{0,1}[0-9]){0,1}[0-9])\.){3,3}(?:25[0-5]|(?:2[0-4]|1{0,1}[0-9]){0,1}[0-9])|(?:[0-9a-fA-F]{1,4}:){1,4}:(?:(?:25[0-5]|(?:2[0-4]|1{0,1}[0-9]){0,1}[0-9])\.){3,3}(?:25[0-5]|(?:2[0-4]|1{0,1}[0-9]){0,1}[0-9]))',  
    "name": r'((?<=name).+)',
    "author": r'(?<=author).+',
    "id": r'[S|T|F|G|A]\d{7}[A-Z]',
    "class": r'(?<=class).+',
    "group": r'(?<=group).+',
    "section": r'(?<=section).+',
    "tutorial": r'(?<=tutorial).+',
    "github_id": r'@([a-z0-9](?:-?[a-z0-9]){0,38})',

}

class Anonymizer():

    def __init__(self, logger, rm_single_comments, rm_block_comments):
        self.anonDicts = {}
        self.logger = logger
        self.rm_single_comments = rm_single_comments
        self.rm_block_comments = rm_block_comments

    def addDicts(self, anon: str):
        if (Regex_Dict.get(anon)):
            self.anonDicts[anon] = Regex_Dict[anon]
            self.logger.info("Added " + anon + "anonymizer type")
        else:
            self.logger.error("Processing parser: You have entered an invalid anonymizer type. Please look at the user guide & enter the appropriate anonymizer type." ) 

    def anonymize(self, text: str, file: str) -> str:
        '''
        Removes single line and block comments and anonymises text with respect to user's options
        '''
        # remove single line comments such as (//, #) if user wants to (only applicable for C/C++/Java/Python files)
        if self.rm_single_comments:
            self.logger.info("[" + str(file) + "] Removing all occurances of single line comments")
            text = re.sub(re.compile("//.*?\n" ), "", text) 
            text = re.sub(re.compile("#.*?\n" ), "", text)

        # remove block line comments such as (/*COMMENT */, ''' COMMENT ''') if user wants to (only applicable for C/C++/Java/Python files)
        if self.rm_block_comments:
            self.logger.info("[" + str(file) + "] Removing all occurances of block line comments")
            text = re.sub(re.compile("/\*.*?\*/",re.DOTALL ) ,"" ,text) 
            text = re.sub(re.compile("'''.*?\n" ), "", text)

        # anonymises specfic anonymiser types that user wants
        for key in self.anonDicts:
            self.logger.info("[" + str(file) + "] Starting to anonymize " + key + " anoymizer type")
            text = self.regex_anonymizer(text, self.anonDicts.get(key), key, file)
        return text

    def getHash(self, word):
        salt = uuid.uuid4().hex
        hash_object = hashlib.sha256((salt + word).encode('utf-8'))
        hex_dig = " " + hash_object.hexdigest()[:16]
        return hex_dig

    def replace_all(self, text: str, matches: Iterable[str], file: str) -> str:
        '''
        Replace all occurance in matchs in text with a hash
        '''
        for match in matches:
            hash = self.getHash(match)
            self.logger.info("[" + str(file) + "] Replacing `" + match + "` with hash `" + hash + "`")
            text = text.replace(match, hash)
        self.logger.info("[" + str(file) + "] Completed replacing obtained matches")
        return text

    def regex_anonymizer(self, text: str, regex: Pattern, type: str, file: str) -> str:
        '''
        Anonymize all substring matching a specific regex with a hash
        '''
        regex = re.compile(regex, re.IGNORECASE)
        self.logger.info("[" + str(file) + "] Finding all occurances of " + type + " anoymizer type")
        matches = re.findall(regex, text)
        return self.replace_all(text, matches, file)

def main():

    # parser options
    parser = argparse.ArgumentParser(description="Anonymize the students submission by replacing sensitive text with hash")
    parser.add_argument("--add", nargs='+', default="all", help="Add anonymizer types")
    parser.add_argument("--rm_single_comments", default=False, help="Remove all the single line comments", type=bool)
    parser.add_argument("--rm_block_comments", default=False, help="Remove all the block comments", type=bool)
    parser.add_argument("--file", default="Test", help="Add folder path of files", type=str, required=False)
    parser.add_argument("--version", action='version', version="Anonymizer v" + __version__, help="print version number and exit")
    args = parser.parse_args()

    # initalize logger
    logging.basicConfig(
        format='%(asctime)s %(levelname)-8s %(message)s',
        level=logging.INFO,
        datefmt='%Y-%m-%d %H:%M:%S'
    )
    logger = logging.getLogger()
    logger.setLevel(logging.DEBUG)

    # create anonymizer class
    anonymizer = Anonymizer(logger, args.rm_single_comments, args.rm_block_comments)

    # add anonymizer options
    if ("all" in args.add):
        anonymizer.anonDicts = Regex_Dict
        logger.info("Added all the anonymizer types")
    else: 
        for anon in args.add:
            anonymizer.addDicts(anon)

    # obtain files from test dir
    test_dir = Path("Test").rglob("*")
    if (args.file):
        test_dir = Path(args.file).rglob("*")
        
    for file in test_dir:
        logger.info("Opening " + str(file))
        readFile = open(file, 'r')
        logger.info("[" + str(file) + "] Copying file content")
        orig_content = readFile.read()
        logger.info("[" + str(file) + "] Starting anonymization")
        anonymized_content = anonymizer.anonymize(orig_content, str(file))

        logger.info("[" + str(file) + "] Completed Anonymization")
        output_filename = join("Output/" + str(os.path.basename(file)))
        output_file = open(output_filename, 'w')
        logger.info("[" + str(file) + "] Saving anonymized content in " + str(output_filename))
        output_file.write(anonymized_content)   
        output_file.close()  

# Call the main function.
main() 