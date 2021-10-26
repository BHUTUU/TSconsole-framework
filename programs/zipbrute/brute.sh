#!/usr/bin/env bash
#By: Suman Kumar ~BHUTUU
#Date: 25-oct-2021
cd $HOME
PWD=$(pwd)
#<<<---requirements---->>>
if ! hash unzip > /dev/null 2>&1; then
apt install unzip -y
fi
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
while true; do
printf "\033[3;4;37mTSc\033[0;0;00m ${S7}Enter(${S1}path/file.zip${S7})> ${R0}"
read source
printf "\033[3;4;37mTSc\033[0;0;00m ${S7}Enter(${S1}path/password/list${S7})> ${R0}"
read psdfile
if [[ ! -f "${source}" || ! -f "${psdfile}" ]]; then
printf "${S2}[${S1}!${S2}]${S4}You have entered false data! Try again with true value!!${R0}!\n"
exit 1
else
break
fi
done
r1=$(basename $source)
out="${r1/.zip/}"
paslist=$(cat $psdfile)
numbs=$(wc -w $psdfile | awk '{print $1}')
for i in $paslist
do
if [[ -z "$t" ]]; then
t=1
fi
sleep 0.5
printf "${S2}[${S4}*${S2}]${S3}Trying${S1}:${S4}${t}${S1}:: ${S4}${i}${R0}\n"
unzip -P "${i}" "${source}" > /dev/null 2>&1
if [[ $? == 0 ]]; then
printf "${S2}[${S1}✓${S2}]${S4}Success!! password ${S1}:: ${S3}${i}${R0}\n"
printf "${S2}[${S4}✓${S2}]${S3}Your ${out}.zip file is extracted in home directory${R0}\n"
break
elif [[ ${t} == ${numbs} ]]; then
echo
printf "${S2}[${S1}!${S2}]${S4}failed!! ${S1}::${S4} Try another password-list${R0}\n"
break
fi
sleep 0.5
rm -rf ${PWD}/$out > /dev/null 2>&1
t=$(echo $((${t}+1)))
done
