#!/bin/bash
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
while true; do
printf "\033[3;4;37mTSc\033[0;0;00m ${S7}Enter(${S1}countrycode/number${S7})> ${R0}"
read  checknum
if [[ -z "${checknum}" ]]; then
echo
printf "${S2}[${S1}!${S2}]${S4} Don't leave it empty!!\e[0m\n"
echo
elif [[ $checknum != '+'* ]]; then
printf "${S2}[${S4}!${S2}]${S3}Enter in international format i.e, +919876543210${R0}\n"
else
reciver=${checknum}
printf "\033[3;4;37mTSc\033[0;0;00m ${S7}Enter(${S1}text/message${S7})> ${R0}"
read TEXTS
break
fi
done
curl -X POST https://textbelt.com/text \
     --data-urlencode phone="$reciver" \
     --data-urlencode message="$TEXTS" \
     -d key=textbelt
echo
