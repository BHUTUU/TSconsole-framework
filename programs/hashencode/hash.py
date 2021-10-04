#!/bin/python
import hashlib
import time
import sys
import getopt
arg1 = None
arg2 = None
argv = sys.argv[1:]
try:
    opts, args = getopt.getopt(argv, "H:P:")
except:
    print("Error")
for opt, arg in opts:
    counter = 1
    if opt in ['-H']:
        arg1 = arg
    elif opt in ['-P']:
        arg2 = arg
word=input("\033[3;4;37mTSc\033[0;0;00m \033[37mEnter(\033[31mtext/to/"+(arg1)+"\033[37m)> \033[00m")
def md5hash():
     hash_object = hashlib.md5(word.encode())
     md5_hash = hash_object.hexdigest()
     print ("\033[3;4;37mTSc\033[0;0;00m \033[37m(\033[31mResult:-\033[37m)> "+md5_hash+" \033[00m\n")
def sha1hash():
     hash_object = hashlib.sha1(word.encode())
     sha1_hash = hash_object.hexdigest()
     print ("\033[3;4;37mTSc\033[0;0;00m \033[37m(\033[31mResult:-\033[37m)> "+sha1_hash+" \033[00m\n")
def sha224hash():
     hash_object = hashlib.sha224(word.encode())
     sha224_hash = hash_object.hexdigest()
     print ("\033[3;4;37mTSc\033[0;0;00m \033[37m(\033[31mResult:-\033[37m)> "+sha224_hash+" \033[00m\n")
def sha256hash():
     hash_object = hashlib.sha256(word.encode())
     sha256_hash = hash_object.hexdigest()
     print ("\033[3;4;37mTSc\033[0;0;00m \033[37m(\033[31mResult:-\033[37m)> "+sha256_hash+ " \033[00m\n")
def sha384hash():
     hash_object = hashlib.sha384(word.encode())
     sha384_hash = hash_object.hexdigest()
     print ("\033[3;4;37mTSc\033[0;0;00m \033[37m(\033[31mResult:-\033[37m)> "+sha384_hash+" \033[00m\n")
def sha512hash():
     hash_object = hashlib.sha512(word.encode())
     sha512_hash = hash_object.hexdigest()
     print ("\033[3;4;37mTSc\033[0;0;00m \033[37m(\033[31mResult:-\033[37m)> "+sha512_hash+" \033[00m\n")
if (arg2 == "md5"):
     md5hash()
elif (arg2 == "sha1"):
     sha1hash()
elif (arg2 == "sha224"):
     sha224hash()
elif (arg2 == "sha256"):
     sha256hash()
elif (arg2 == "sha384"):
     sha384hash()
elif (arg2 == "sha512"):
     sha512hash()
else:
     print ("\033[3;4;37mTSc\033[0;0;00m \033[37m(\033[31mResult:-\033[37m)> \033[32m[\033[31m!\033[32m]\033[34mLol! you are trying to copy my program${R0} 😂😂\n")
