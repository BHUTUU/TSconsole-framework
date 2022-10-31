#!/usr/bin/bash
Hid="\033[?25l"
Sho="\033[?12l\033[?25h"
times=${1:?Number of cycles required}
printf "${Hid}"
spinner=('|' '/' '-' '\\')
for repeat in $(seq $times); do
  for spin in ${spinner[*]}; do
#  printf " ${spin} \r" |figlet; printf "\033[6A"
   printf " ${spin} \r"
    sleep 0.3
  done
done
printf "${Sho}"
