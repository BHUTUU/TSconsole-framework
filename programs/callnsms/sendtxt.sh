#!/bin/bash
#Author: Suman Kumar
#A part of TSconsole-framework
#<<<-----colors----->>>#
S1="\033[1;31m" S2="\033[1;32m"
S3="\033[1;33m" S4="\033[1;34m"
S6="\033[1;36m" S7="\033[1;37m"
R0="\033[00m"
#<---x--->#
while true; do
printf "\033[3;4;37m$(uname -o)\033[0;0;00m ${S7}Enter(${S1}number with country code${S7})> ${R0}"
read  checknum
if [[ -z "${checknum}" ]]; then
echo
printf "${S2}[${S1}!${S2}]${S4} Don't leave it empty!!\e[0m\n"
echo
elif [[ $checknum != '+'* ]]; then
printf "${S2}[${S4}!${S2}]${S3}Enter in international format i.e, +919876543210${R0}\n"
else
reciver=${checknum}
printf "\033[3;4;37m$(uname -o)\033[0;0;00m ${S7}Enter(${S1}text/message${S7})> ${R0}"
read TEXTS
break
fi
done
curl -X POST https://textbelt.com/text \
     --data-urlencode phone="$reciver" \
     --data-urlencode message="$TEXTS" \
     -d key=textbelt
echo
