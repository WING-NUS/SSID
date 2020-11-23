import os
import re
import hashlib
from os.path import join, getsize, isfile

tokens = [r'(?<=name).+',     
          r'(?<=author).+',
          r'(?<=class).+',
          r'(?<=group).+',
          r'(?<=section).+',
          r'(?<=tutorial).+',
          r'(?<=handle).+',
          r'.+(?=com)',
          r'.+(?=edu)',
          r'.+(?=gov)',
          r'.+(?=gov)',
          r'.+(?=sg)'
          ]


def produceHash(word):

    hash_object = hashlib.sha256(word)
    hex_dig = " " + hash_object.hexdigest()[:8]
    return hex_dig

def main():

    path = [Insert path of folder where the test files are stored] 
    # Example: 'C:\\Users\\Documents\\SSID-Test-Data'
    
    files = []
    matches = []
    
    for root, dirs, files in os.walk(path):
        for filename in files:
            if not filename.startswith('.'):
                outputDirPath = os.path.join(Insert path of output folder)
                # Example: 'C:\\Users\\riyas\\Desktop\\OutputTest'
                if not (os.path.isdir(path)):
                    os.mkdir(outputDirPath)
                    print("Directory '% s' created" % outputDirPath)
                filename = join(root, filename)
                myfile = open(filename, 'r')
                print ('Opening ' + filename)
                content = myfile.read()
                for token in tokens:
                    matches = re.findall(token, content, flags = re.I)
                    for match in matches:
                        content = re.sub(match, produceHash(match.encode('utf-8')), content, flags = re.I)
                outputFileName = join(outputDirPath, "Name of output file")
                print ('Contents anonymised & copied to ' + outputFileName)
                myfile = open(outputFileName, 'w')
                myfile.write(content)   
                myfile.close()               

# Call the main function.
main()