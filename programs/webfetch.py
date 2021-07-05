#!/bin/python
import requests
import os, sys
print ("\033[1;37m            _")
print ("\033[1;37m           | |")
print ("\033[1;36m         _ | |    _   __,   __,  _")
print ("\033[1;36m|  |  |_|/ |/ \_|/ \_/  |  /  | |/")
print ("\033[1;33m \/ \/  |__/\_/ |__/ \_/|_/\_/|/|__/")
print ("\033[1;33m               /|            /|")
print ("\033[1;33m               \|            \|\033[1;32;44m content Viewer \033[0;0;0m\n")
print ("\033[1;33m<<<---Welcome to webpage content viewer--->>>")
print ("\033[1;31m >>Authored by:- Suman Kumar ~BHUTUU")
print ("\n")
os.system('''
          PWD=$(pwd)
          cd $HOME
          while true
          do
          wfin=$(find webout.txt)
          if [[ $wfin == webout.txt ]]; then
          printf "\e[1;33m>You have downloaded a raw web earlier so in order to save it move it in other directory for this execute 'move' else execute 'run' to continue =>> \e[1;31m"
          read mvrun
          if [[ $mvrun == move ]]; then
          echo
          printf "\e[1;34m>Enter the path where you want to move it==> \e[1;31m"
          read wepath
          mv -v webout.txt $wepath
          break
          elif [[ $mvrun == run ]]; then
          printf "\e[1;92m continuing........\e[0m\n"
          break
          else
          printf "\e[1;97m Error: Please execute valid command :(\e[0m\n"
          fi
          else
          printf "\e[1;97m>>Don't worry the above statement is not an error :) \e[0m\n"
          break
          fi
          done
         ''')
url = input('\033[1;34mEnter your URL here ==> \033[1;37m')
print ("\n")
response = requests.get(url)
response.content
os.system('''
          printf "\e[1;36mDownloading.\e[0m"
          sleep 0.2
          printf "\e[1;36m.\e[0m"
          sleep 0.2
          printf "\e[1;36m.\e[0m"
          sleep 0.2
          printf "\e[1;36m.\e[0m"
          sleep 0.2
          printf "\e[1;36m.\e[0m\n"
          printf "\n"
         ''')
sys.stdout = open("webout.txt", "w")
print ("\033[1;36m>Result==>\033[1;32mm",(response.content))
sys.stdout.close()
os.system('''mv -v webout.txt $HOME && echo
             printf "\e[1;30;107m RAW Webpage is saved in HOME directory with name webout.txt\e[0;0;0m\n"
        ''')

