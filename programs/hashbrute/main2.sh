#!/bin/bash
#<<--colour code-->>#
S0="\033[1;30m" B0="\033[1;40m"
S1="\033[1;31m" B1="\033[1;41m"
S2="\033[1;32m" B2="\033[1;42m"
S3="\033[1;33m" B3="\033[1;43m"
S4="\033[1;34m" B4="\033[1;44m"
S5="\033[1;35m" B5="\033[1;45m"
S6="\033[1;36m" B6="\033[1;46m"
S7="\033[1;37m" B7="\033[1;47m"
R0="\033[00m"   R1="\033[1;00m"
#<<--program-->>#
printf "\033[3;4;37mTSc\033[0;0;00m ${S7}Enter(${S1}hash/code${S7})> ${R0}"
read hash
hashlen=$(printf "${hash}" | awk '{print length}')
case "${hashlen}" in
32)
htype="md5sum"
;;
40)
htype="sha1sum"
;;
56)
htype="sha224sum"
;;
64)
htype="sha256sum"
;;
96)
htype="sha384sum"
;;
128)
htype="sha512sum"
;;
*)
echo
printf "${S2}[${S1}!${S2}]${S1}Sorry! Bruteforce for this type of code is unavailable${R0}\n"
exit 1
;;
esac
printf "\033[3;4;37mTSc\033[0;0;00m ${S7}Enter(${S1}path/word/list${S7})> ${R0}"
read file
numbs=$(wc -w $file | awk '{print $1}')
printf "\n${S2}${htype} hash code ;)${R0}\n\n"
sleep 1.7
while read -r i
do
if [[ -z "$t" ]]; then
t=1
fi
printf "${S2}[${S4}*${S2}]${S3}Trying${S1}:${S4}${t}${S1}:: ${S4}${i}${R0}\n"
word=$(echo "${i}" | ${htype} | awk '{print $1}')
if [[ ${word} == ${hash} ]]; then
echo
printf "${S2}[${S1}✓${S2}]${S4}Success!! word ${S1}:: ${S3}${i}${R0}\n"
break
elif [[ ${t} == ${numbs} ]]; then
echo
printf "${S2}[${S1}!${S2}]${S4}failed!! ${S1}::${S4} Try another wordlist${R0}\n"
break
fi
t=$(echo $((${t}+1)))
done < "$file"
