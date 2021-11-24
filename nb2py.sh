
# echo "We first remove all spaces in file name!"
# for d in $(find /Users/yisong/SSID/ME5406-rm-env -maxdepth 1 -type d)
# do
#   #Do something, the directory is accessible with $d:
#   cd $d
#   echo $d

#   for file in $(pwd)/*
#   	do
#   	# echo $file
#   		mv "$file" "${file// /_}"
#   	done

#   cd ..

# done




for d in $(find /Users/yisong/SSID/ME5406-rm-env -maxdepth 1 -type d)
do
  #Do something, the directory is accessible with $d:
  cd $d
  echo $d

  for file in $(pwd)/*
  do
  	# echo $file
  	if [[ $file == *.ipynb ]]
  	then
  		echo $file
  		jupyter nbconvert --to script $file
  		rm $file
  		echo "jupyter converted and rm!"
  	fi
  done

  cd ..

done
