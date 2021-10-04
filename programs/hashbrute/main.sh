#!/bin/bash
CWD=$(pwd)
#<<<-----colors----->>>#
S0="\033[1;30m" B0="\033[1;40m"
S1="\033[1;31m" B1="\033[1;41m"
S2="\033[1;32m" B2="\033[1;42m"
S3="\033[1;33m" B3="\033[1;43m"
S4="\033[1;34m" B4="\033[1;44m"
S5="\033[1;35m" B5="\033[1;45m"
S6="\033[1;36m" B6="\033[1;46m"                                                                      S7="\033[1;37m" B7="\033[1;47m"
R0="\033[00m"   R1="\033[1;00m"

cd programs/hashbrute > /dev/null 2>&1
printf "\033[3;4;37mTSc\033[0;0;00m ${S7}Enter(${S1}hash/code${S7})> ${R0}"
read hash
ha_s=$(printf "${hash}" | awk '{print length}')
printf "\033[3;4;37mTSc\033[0;0;00m ${S7}Enter(${S1}path/dictinary${S7})> ${R0}"
read dicpath
case "${ha_s}" in
32)
printf "${S2}MD5 hash code ;)${R0}\n"
sleep 1.7
./md5brute.py -H ${hash} -P ${dicpath}
;;
40)
printf "${S2}SHA1 hash code ;)${R0}\n"
sleep 1.7
./sha1brute.py -H ${hash} -P ${dicpath}
;;
56)
printf "${S2}SHA224 hash code ;)${R0}\n"
sleep 1.7
./sha224brute.py -H ${hash} -P ${dicpath}
;;
64)
printf "${S2}SHA256 hash code ;)${R0}\n"
sleep 1.7
./sha256brute.py -H ${hash} -P ${dicpath}
;;
96)
printf "${S2}SHA384 hash code ;)${R0}\n"
sleep 1.7
./sha384brute.py -H ${hash} -P ${dicpath}
;;
128)
printf "${S2}SHA512 hash code ;)${R0}\n"
sleep 1.7
./sha512brute.py -H ${hash} -P ${dicpath}
;;
*)
echo
printf "${S2}[${S1}!${S2}]${S1}Sorry! Bruteforce for this type of code is unavailable${R0}\n"
echo
esac
cd $CWD > /dev/null 2>&1
