#!/bin/bash
args="$@"
#<<<-----colors----->>>#
S0="\033[1;30m" B0="\033[1;40m"
S1="\033[1;31m" B1="\033[1;41m"
S2="\033[1;32m" B2="\033[1;42m"
S3="\033[1;33m" B3="\033[1;43m"
S4="\033[1;34m" B4="\033[1;44m"
S5="\033[1;35m" B5="\033[1;45m"
S6="\033[1;36m" B6="\033[1;46m"
S7="\033[1;37m" B7="\033[1;47m"
R0="\033[00m"   R1="\033[1;00m"
#<---x--->#
printf "\033[3;4;37mTSc\033[0;0;00m ${S7}Enter(${S1}text/to/${args}/hash${S7})> ${R0}"
read text
if [[ $args == *'md5'* ]]; then
hash=$(echo "${text}" | md5sum | awk '{print $1}')
elif [[ $args == *'sha1'* ]]; then
hash=$(echo "${text}" | sha1sum | awk '{print $1}')
elif [[ $args == *'sha224'* ]]; then
hash=$(echo "${text}" | sha224sum | awk '{print $1}')
elif [[ $args == *'sha256'* ]]; then
hash=$(echo "${text}" | sha256sum | awk '{print $1}')
elif [[ $args == *'sha384'* ]]; then
hash=$(echo "${text}" | sha384sum | awk '{print $1}')
elif [[ $args == *'sha512'* ]]; then
hash=$(echo "${text}" | sha512sum | awk '{print $1}')
else
hash=$(printf "${S2}[${S1}!${S2}]${S4}Lol! you are trying to copy my program${R0} 😂😂\n")
fi

printf "\033[3;4;37mTSc\033[0;0;00m ${S7}(${S1}Result:-${S7})> ${hash} ${R0}\n"
