/*
 *  cpythontest.c
 *  CPP
 *
 *  Created by Ales Teska on 6.10.09.
 *  Copyright 2009 Exidius. All rights reserved.
 *
 */

#include <assert.h>
#include "python3Lexer.h"
#include "python3Parser.h"

/////////////////////////////////////////

// String replace method in C; We need this to replace newline characters with its escaped version
char *str_replace(char *input, char *pattern, char *replacement) {
    char *result;        // the return string
    char *ins;           // the next insert point
    char *tmp;
    int len_pattern;     // length of pattern
    int len_replacement; // length of replacement
    int len_unchanged;   // distance between pattern and end of previous pattern
    int count;           // number of replacements

    // Sanity Check
    if (input == NULL) {
      return NULL;
    }
    if (replacement == NULL) {
      replacement = "";
    }
    len_replacement = strlen(replacement);
    len_pattern = strlen(pattern);

    // Init
    if (pattern == NULL || !(len_replacement = strlen(replacement))) {
      return NULL;
    }

    // Find number of replacements
    ins = input;
    count = 0;
    tmp = strstr(ins, pattern);
    while (tmp != NULL) {
      ++count;
      if (strlen(tmp) > len_pattern) {
        ins = tmp + len_pattern;
      } else {
        break;
      }
      tmp = strstr(ins, pattern);
    }

    // If no replacement needs to be done, return a copy of original string
    if (count == 0) {
      result = malloc(strlen(input) + 1);
      memcpy(result, input, strlen(input) + 1);
      return result;
    }

    // Allocate memory for final string with replacement
    tmp = result = malloc(strlen(input) + (len_replacement - len_pattern) * count + 1);
    if (result == NULL) {
      return NULL;
    }

    // tmp points to the end of the result string
    // ins points to the next occurrence of pattern in input
    // input points to the remainder of input after "end of pattern"
    char *remainder = input;
    while (count > 0) {
      ins = strstr(remainder, pattern);
      len_unchanged = strlen(remainder) - strlen(ins);
      tmp = strncpy(tmp, remainder, len_unchanged) + len_unchanged;
      tmp = strncpy(tmp, replacement, len_replacement) + len_replacement;
      remainder += len_unchanged + len_pattern; // move to next "end of pattern"
      --count;
    }
    strcpy(tmp, remainder);

    return result;
}

int main(int argc, char *argv[])
{
	assert(argc == 2);

	pANTLR3_INPUT_STREAM input = antlr3FileStreamNew((pANTLR3_UINT8)argv[1], 4); // antlr3AsciiFileStreamNew((pANTLR3_UINT8)argv[1]);
	assert(input != NULL);

	// Create lexer
	ppython3Lexer lxr = python3LexerNew(input);
	assert(lxr != NULL);

  // SSID: Print tokens to stdout
  pANTLR3_TOKEN_SOURCE tokSource = lxr->pLexer->rec->state->tokSource;
  pANTLR3_COMMON_TOKEN currToken = tokSource->nextToken(tokSource);
  ANTLR3_COMMON_TOKEN eofToken = tokSource->eofToken;
  unsigned int startPosition = 0, tokenLength;  // position and length of token in original code
  while (currToken->getType(currToken) != eofToken.getType(&eofToken)) 
  {
    char *tokenString = (char *) currToken->getText(currToken)->chars;
    tokenLength = strlen(tokenString);
    char *newTokenString = str_replace(tokenString, "\n", "\\n");
    printf("%u,%u,%u,%u,%s\n", currToken->getLine(currToken), startPosition, tokenLength, currToken->getType(currToken), newTokenString);
    startPosition += tokenLength;
    currToken = tokSource->nextToken(tokSource);
 //   free(newTokenString);
  }
/*
	// Create token stream
	pANTLR3_COMMON_TOKEN_STREAM tstream = antlr3CommonTokenStreamSourceNew(ANTLR3_SIZE_HINT, TOKENSOURCE(lxr));
	assert(tstream != NULL);
	tstream->discardOffChannelToks(tstream, ANTLR3_TRUE);

	// Create parser
	ppython3Parser psr = python3ParserNew(tstream);
	assert(psr != NULL);

	// Parse ...
	psr->file_input(psr);
*/
    // Clean up /////////////////////////////////////////
	//psr->free(psr);
	//psr = NULL;

	//tstream->free(tstream);
	//tstream = NULL;

	lxr->free(lxr);
	lxr = NULL;

	input->close(input);
	input = NULL;
 
	return(0);
}
