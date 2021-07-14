#!/bin/bash
cdir=$(pwd)
#<<<-----Distro verification------>>>
cd $HOME
sleep 1
distro=$(pwd)
if [[ $distro == '/data/data/com.termux/files/home' ]]; then
	user="/data/data/com.termux/files/home"
	rootdir="/data/data/com.termux/files/usr"
elif [[ $distro == '/data/data/hilled.pwnterm/files/usr/home' ]]; then
	user="/data/data/hilled.pwnterm/files/usr/home"
	rootdir="/data/data/hilled.pwnterm/files/usr"
else
	rootdir="/usr"
fi
cd $cdir
cd ..
PWD=$(pwd)
schek=$(find TSconsole-framework)
sleep 1
if [[ $schek == 'TSconsole-framework' ]]
then
    printf "\e[1;33m Thank you for cloning TSconsole-framework in your termux\e[0m\n"
    cd TSconsole-framework && git pull
else
    git clone https://github.com/BHUTUU/TSconsole-framework
    cd TSconsole-framework
sleep 1
    chmod +x *
    cd Assets
    chmod +x * && cd ..
    cd programs
    chmod +x * && cd ..
    bash requirements
fi
sleep 1
cd ${rootdir}/share
che=$(find TSconsole-framework)
sleep 1
if [[ $che == 'TSconsole-framework' ]]
then
    rm -rf TSconsole-framework
else
    printf "\e[1;34m old version not found to delete\e[0m\n"
fi
cd ${rootdir}/bin
chk=$(find TSconsole)
sleep 1
if [[ $chk == 'TSconsole' ]]
then
    rm -rf TSconsole
else
    printf "\e[1;32m Old launcher not found to delete\e[0m\n"
fi
cd $PWD
sleep 1
mv -v TSconsole-framework ${rootdir}/share
cd $rootdir/share/TSconsole-framework
sleep 1
cd ${rootdir}/bin
echo "#!/bin/bash" > TSconsole
echo 'TDIR="$rootdir/share/TSconsole-framework"' >> TSconsole
echo 'LAUNCHTS="TSconsole"' >> TSconsole
echo >> TSconsole
echo "cd ${TDIR}" >> TSconsole
echo "bash ${LAUNCHTS} ${@}
Tsconsole
