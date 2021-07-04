#! bin/bash
cdir=$(pwd)
cd ..
schek=$(find TSconsole-framework)
sleep 1
if [[ $schek == 'TSconsole-framework' ]]
then
    printf "\e[1;33m Thank you for cloning TSconsole-framework in your termux\e[0m\n"
else
    git clone https://github.com/BHUTUU/TSconsole-framework
    cd TSconsole-framework
sleep 1
    chmod +x *
    cd Assets
    chmod +x * && cd ..
    bash requirements
fi
sleep 1
cd /data/data/com.termux/files/usr/share
che=$(find TSconsole-framework)
sleep 1
if [[ $che == 'TSconsole-framework' ]]
then
    rm -rf TSconsole-framework
else
    printf "\e[1;34m old version not found to delete\e[0m\n"
fi
cd /data/data/com.termux/files/usr/bin
chk=$(find TSconsole)
sleep 1
if [[ $chk == 'TSconsole' ]]
then
    rm -rf TSconsole
else
    printf "\e[1;32m Old launcher not found to delete\e[0m\n"
fi
cd $cdir
cd ..
sleep 1
mv -v TSconsole-framework /data/data/com.termux/usr/share
cd /data/data/com.termux/files/usr/share/TSconsole-framework
chmod +x *
cd Assets
sleep 1
chmod +x * && cd ..
sleep 1
ln -sf /data/data/com.termux/files/usr/share/TSconsole-framework/TSconsole /data/data/com.termux/files/usr/bin/TSconsole
Tsconsole
