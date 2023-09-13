





  double calc_percentage_accuracy
(long num_of_testing_samples, long num_read_wrong)
{
  return
    ((num_of_testing_samples -
      (double)num_read_wrong)/num_of_testing_samples)*100.00;
}

int main()
{
    const long num_of_training_samples = cs1010_read_long();

    struct sample_holder *training_samples = calloc(num_of_training_samples,
      sizeof(struct sample_holder));

  read_input(num_of_training_samples, training_samples);
    const long num_of_testing_samples = cs1010_read_long();

    struct sample_holder *testing_samples = calloc(num_of_testing_samples,
      sizeof(struct sample_holder));;

    read_input(num_of_testing_samples, testing_samples);
}