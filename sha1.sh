#!/bin/bash
printf "Enter your text----> "
read "text"
text=$(echo -n "$text" | sha1sum | awk '{print $1}')
printf "$text\n"
printf "Enter your text----> "
read "text"
text=$(printf "$passd" | md5sum | awk '{printf $1}')
printf "$text\n"

