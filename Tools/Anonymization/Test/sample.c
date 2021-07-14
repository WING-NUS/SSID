/**
 * CS1010 Semester 1 AY18/19
 * Assignment 9: Digits
 *
 * This program is utilised to identify hand written letters which were 
 * converted to a 28 by 28 size canvas with empty space denoted by '.' and the 
 * portion of the character dentoted by '#'. This allows the program to detect
 * a digit by checking against a pre generated database of samples called 
 * training samples against the sample being tested called the testing sample
 * each digit tested and what it was detected as is printed and finally the 
 * accuracy of detection is printed to the user output! 
 * 
 * @file: digits.c
 */

// email: e100000@u.nus.edu itzme@gmail.com 
// url: www.cs1010.nus.edu.sg https://google.com http://yahoo.com/thisarticle
// mac: 3D:F2:C9:A6:B3:4F
// ipv4: 192.0.2.146
// ipv6: 2001:0db8:85a3:0000:0000:8a2e:0370:7334
// name: Riyas
// NAME: Riyas
// author: Mohamed Riyas
// Author: Riyas
// hp: 61234567
// student id: A9876543P
// ic: S1234567A T2121211P 
// github handle: @riyasTheCode


#include <stdlib.h>
#include <math.h>
#include "cs1010.h"

#define NCOLS 28 // The predefined number of columns
#define NROWS 28 // The predefined number of rows

/**
 * This function is used to obtain the both the training samples and the 
 * testing samples by using the defined class to properly allocate both the 
 * label and the actual sample
 * 
 * @param[in] num_of_testing_samples this is the total number of digits checked
 * @param[in] num_read_wrong is the digits that were recognized wrongly 
 *            
 * @pre The pre condition all the testing samples were checked
 *
 * @post The accuracy of the recognition is determined and then returned
 * 
 * @return The final percentage accuracy calculated is returned in double
 *      
 */
  double calc_percentage_accuracy
(long num_of_testing_samples, long num_read_wrong)
{
  return
    ((num_of_testing_samples -
      (double)num_read_wrong)/num_of_testing_samples)*100.00;
}

int main()
{
  // The number of training samples is read
  const long num_of_training_samples = cs1010_read_long();

  // Allocation of memory for the array of training samples
  struct sample_holder *training_samples = calloc(num_of_training_samples,
      sizeof(struct sample_holder));

  read_input(num_of_training_samples, training_samples);
  // The number of testing samples is read
  const long num_of_testing_samples = cs1010_read_long();

  // Allocation of memory for the array of testing samples
  struct sample_holder *testing_samples = calloc(num_of_testing_samples,
      sizeof(struct sample_holder));;

  // This obtains the testing/training samples
  read_input(num_of_testing_samples, testing_samples);
}