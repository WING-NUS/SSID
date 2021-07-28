# Anonymization App

This is a text anonymization app for users to anonymize different parts of a text that are deemed to be private and confidential (e.g. student id, handphone number, name of individual, etc.). In addition, this app also provides the option to remove single line and block comments.

## Usage

1. Ensure that all the files to be anonymized are placed under the `Test` folder. 
2. Then, enter the below command:

<pre> python main.py --add [ANONYMIZER_TYPES] --rm_single_comments [BOOLEAN_OPTION] --rm_block_comments [BOOLEAN_OPTION] --file [FILEPATH] </pre>

- --add ANONYMIZER_TYPES refers to the anonymizer types that you would like the application to detect and then replace such occurances. If you want to include all the anonymizer types that this application can detect, simply enter `--add all`. Else, if you want to selectively add anonymizer types, refer to the below section.

- --rm_single_comments indicates whether do you want the app to remove all single line comments from the given input files (to be placed under `Test` folder as written above). Please note that this feature can only be applied for C/C++/Java/Python files. If you want the app to remove all single line comments, enter `--rm_single_comments yes`. Otherwise, enter `--rm_single_comments no`. 

- --rm_block_comments indicates whether do you want the app to remove all block line comments from the given input files (to be placed under `Test` folder as written above). Please note that this feature can only be applied for C/C++/Java/Python files. If you want the app to remove all block line comments, enter `--rm_block_comments yes`. Otherwise, enter `--rm_block_comments no`.

- --file [FILEPATH] indicates the path of folder from which to recursively search for files to do anonymization. You can ignore this if the files are under the `Test` directory as stated above in (1).
 
## Anonymizer Type Options
- `mac`: anonymizes all occurances of any MAC address
- `phone`: anonymizes all occurances of any Singapore registered phone number
- `email`: anonymizes all occurances of any email address
- `url`: anonymizes all occurances of any url address
- `ipv4`: anonymizes all occurances of any ipv4 address
- `ipv6`: anonymizes all occurances of any ipv6 address
- `name`: anonymizes all occurances of any individual names provided it is preceded by "name" string
- `author`: anonymizes all occurances of any individual author names provided it is preceded by "author" string
- `id`: anonymizes all occurances of any Singapore NRIC or NUS Student ID
- `class`: anonymizes all occurances of any class details provided it is preceded by "class" string
- `group`: anonymizes all occurances of any group details provided it is preceded by "group" string
- `section`: anonymizes all occurances of any section details provided it is preceded by "section" string
- `tutorial`: anonymizes all occurances of any tutorial group details provided it is preceded by "tutorial" string
- `github_id`: anonymizes all occurances of any user GitHub username