#!/bin/bash
PWD=$(pwd)
printf "\e[1;32m\e[44m>>TSconsole-framework is INSTALLING AND UPDATING\e[0m\n"
printf "\e[1;33mplease wait\e[0m"
printf "\e[1;33m.\e[0m"
sleep 0.2
printf "\e[1;33m.\e[0m"
sleep 0.2
printf "\e[1;33m.\e[0m"
sleep 0.2
printf "\e[1;33m.\e[0m"
sleep 0.2
printf "\e[1;33m.\e[0m"
sleep 0.2
printf "\e[1;33m.\e[0m\n"
#<<<------DISTRO VERIFICATION------>>>
cd $HOME
distro=$(pwd)
if [[ $distro == /data/data/com.termux/files/home ]]
then
cd .. && cd usr/bin
elif [[ $distro == /data/data/hilled.pwnterm/files/usr/home ]]
then
cd .. && cd bin
else
cd /usr/bin
exit
fi
#<<<-----remove TSconsole----->>>
bhu=$(find TSconsole)
if [[ $bhu == TSconsole ]]
then
rm -rf TSconsole
fi
sleep 2
#<<<------remove TSconsole-framework------->>>
cd .. && cd share
rm -rf TSconsole-framework
printf "\e[1;90m Old files are deleted\e[0m\n"
sleep 2
echo
printf "\e[1;35mOld version is completely removed\e[0m\n"
printf "\e[1;34m\e[46mplease do not stop here the process by any chance...........\e[0m\n"
echo
sleep 0.7
#<<<------downloading latest TSconsole-framework------>>>
printf "\e[1;32mInstalling latest version\e[0m"
sleep 0.5
printf "\e[1;32m.\e[0m"
sleep 0.2
printf "\e[1;32m.\e[0m"
sleep 0.2
printf "\e[1;32m.\e[0m"
sleep 0.2
printf "\e[1;32m.\e[0m\n"
cd .. && cd share
git clone https://github.com/BHUTUU/TSconsole-framework
#<<<------adding permissions to programs------>>>
cd TSconsole-framework
chmod u+x *
cd assets
chmod +x * && cd ..
cd programs
cd BRUTE
chmod +x * && cd ..
cd PHISH
chmod +x * && cd sites && chmod 7777 * && cd .. && cd ..
cd WEBFETCH && chmod +x * && cd ..
cd HASHES && chmod +x * && cd ..
cd ..

#<<<----moving programs in bin directory for TERMUX------>>>
if [[ $distro == /data/data/com.termux/files/home ]]
then
cd /data/data/com.termux/files/usr/share/TSconsole-framework && ./requirements
cd /data/data/com.termux/files/usr/bin
echo "#!/data/data/com.termux/files/usr/bin/bash" > TSconsole
echo 'TDIR="/data/data/com.termux/files/usr/share/TSconsole-framework"' >> TSconsole
echo 'LAUNCHTS="TSconsole"' >> TSconsole
echo >> TSconsole
echo 'cd ${TDIR}' >> TSconsole
echo 'bash ${LAUNCHTS} ${@}' >> TSconsole
chmod +x TSconsole
#<<<------moving programs in bin directory for PWN-TERM------>>>
elif [[ $distro == /data/data/hilled.pwnterm/files/usr/home ]]
then
cd /data/data/hilled.pwnterm/files/usr/share/TSconsole-framework && ./requirements
sleep 1
cd /data/data/hilled.pwnterm/files/usr/bin
echo "#!/data/data/hilled.pwnterm/files/usr/bin/bash" > TSconsole
echo 'TDIR="/data/data/hilled.pwnterm/files/usr/share/TSconsole-framework"' >> TSconsole
echo 'LAUNCHTS="TSconsole"' >> TSconsole
echo >> TSconsole
echo 'cd ${TDIR}' >> TSconsole
echo 'bash ${LAUNCHTS} ${@}' >> TSconsole
chmod +x TSconsole
else
cd /usr/share/TSconsole-framework && ./requirements
cd usr/bin
echo "#!/bin/bash" > TSconsole
echo 'TDIR="/usr/share/TSconsole-framework"' >> TSconsole
echo 'LAUNCHTS="TSconsole"' >> TSconsole
echo >> TSconsole
echo 'cd ${TDIR}' >> TSconsole
echo 'bash ${LAUNCHTS} ${@}' >> TSconsole
chmod +x TSconsole
exit
fi
#<<<------user guide after installation------>>>
printf "\e[1;32m\e[104mLatest vesion of TSconsole-framework is installed\e[0m\n"
printf "\n"
printf "\e[1;36mRun:- \e[1;34;42m TSconsole \e[1;36;0m to use it\e[0m\n"
echo
printf "\e[1;31m\e[104mEver you want to update just Run \e[1;34;42m TSconsole -u \e[0;0;0m\n"
echo
printf "\e[1;96mIf you liked it then please give us a star '✰' on github :)\e[0m\n"
printf "\e[1;91mTHANK YOU!!!\e[0m\n"
echo
printf "\e[1;97mplease run \e[1;34;42m cd \$HOME \e[1;97;0m if \e[1;34;42m ls \e[1;31;0m command gives any error\e[1;0m\n"


#Direct link for TSconsole-framework installation:- (" bash <(curl -fsSL "https://bit.ly/3jKxqmK") -i ")
#Written by:- Suman Kumar ~BHUTUU



#<<<-----xxxxx-----xxxxx-----END-----xxxxx-----xxxxx----->>>
