#!/bin/python
import requests
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
url = input('Enter your url here ==> ')
print ("\n")
response = requests.get(url)
response.content
print ("\033[1;36m>Result==>\033[1;32mm",(response.content))
