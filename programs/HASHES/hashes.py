#!/bin/python
import hashlib, base64
import time
def wait():
	time.sleep(0.025)
while True:
	print ("\033[1;35m<<<----Text to Hash converter---->>>\n"); wait()
	print ("\n"); wait()
	print ("\033[1;37mChoose from following options:-\n"); wait()
	print ("\n"); wait()
	print ("\033[1;37m1:Text to MD5 converter."); wait
	print ("\033[1;37m2:Text to SHA1."); wait()
	print ("\033[1;37m3:TEXT to SHA224."); wait()
	print ("\033[1;37m4:Text to SHA256."); wait()
	print ("\033[1;37m5:Text to SHA384."); wait()
	print ("\033[1;37m6:Text to SHA512."); wait()
	print ("\033[1;37m7:Text to BASE64."); wait()
	print ("\033[1;37m8:Text to BASE32."); wait()
	print ("\033[1;37m>>Run 'back' to go to main programs list."); wait()
	print ("\n")
	optn = input("\033[4;2;37mTSc \033[0;0;0m> \033[1;32m(Enter your option)> ")
	print ("\n")
	if (optn == '1'):
		time.sleep (0.4)
		print ("\033[1;35m<<<---welcome to Text to MD5 converter--->>>"); wait()
		print ("\n"); wait()
		mystring = input("\033[4;2;37mTSc \033[0;0;0m> \033[1;31m(Enter your text)> ")
		hash_object = hashlib.md5(mystring.encode())
		print ("\033[4;2;37mTSc \033[0;0;0m> \033[1;34m(Result)>",(hash_object.hexdigest())); wait()
		print ("\n"); wait()
		time.sleep (0.4)
		read = input("\033[4;2;37mTSc \033[0;0;0m> \033[1;36m>>(choose '1' To open the program again and any other button to exit)> ")
		if (read == '1'):
			print ("\033[4;2;37mTSc \033[0;0;0m> \033[1;32mrestarting the program"); wait()
			print ("\n"); wait()
			print ("\n")
			time.sleep (1)
		else:
			exit()
	elif (optn == '2'):
		time.sleep (0.4)
		print ("\033[1;35m<<<---welcome to Text to SHA1 converter--->>>"); wait()
		print ("\n"); wait()
		mystring = input("\033[4;2;37mTSc \033[0;0;0m> \033[1;31mEnter your text)> ")
		hash_obj = hashlib.sha1(mystring.encode())
		print ("\033[4;2;37mTSc \033[0;0;0m> \033[1;34m(Result)>",(hash_obj.hexdigest())); wait()
		print ("\n")
		time.sleep (0.4)
		read = input("\033[4;2;37mTSc \033[0;0;0m> \033[1;36m>>(choose '1' To open the program again and any other button to exit)> ")
		if (read == '1'):
			print ("\033[4;2;37mTSc \033[0;0;0m> \033[1;32mrestarting the program"); wait()
			print ("\n"); wait()
			print ("\n")
			time.sleep (1)
		else:
			exit()
	elif (optn == '3'):
		time.sleep (0.4)
		print ("\033[1;35m<<<---welcome to Text to SHA224 converter--->>>"); wait()
		print ("\n"); wait()
		mystring = input("\033[4;2;37mTSc \033[0;0;0m> \033[1;31mEnter your text)> ")
		hash_obj = hashlib.sha224(mystring.encode())
		print ("\033[4;2;37mTSc \033[0;0;0m> \033[1;34m(Result)>",(hash_obj.hexdigest())); wait()
		print ("\n")
		time.sleep (0.4)
		read = input("\033[4;2;37mTSc \033[0;0;0m> \033[1;36m>>(choose '1' To open the program again and any other button to exit)> ")
		if (read == '1'):
			print ("\033[4;2;37mTSc \033[0;0;0m> \033[1;32mrestarting the program"); wait()
			print ("\n"); wait()
			print ("\n")
			time.sleep (1)
		else:
			exit()
	elif (optn == '4'):
		time.sleep (0.4)
		print ("\033[1;35m<<<---welcome to Text to SHA256 converter--->>>"); wait()
		print ("\n"); wait()
		mystring = input("\033[4;2;37mTSc \033[0;0;0m> \033[1;31m(Enter your text)> ")
		hash_obj = hashlib.sha256(mystring.encode())
		print ("\033[4;2;37mTSc \033[0;0;0m> \033[1;34m(Result)>",(hash_obj.hexdigest())); wait()
		print ("\n")
		time.sleep (0.4)
		read = input("\033[4;2;37mTSc \033[0;0;0m> \033[1;36m>>(choose '1' To open the program again and any other button to exit)> ")
		if (read == '1'):
			print ("\033[4;2;37mTSc \033[0;0;0m> \033[1;32mrestarting the program"); wait()
			print ("\n")
			print ("\n")
			time.sleep (1)
		else:
			exit()
	elif (optn == '5'):
		time.sleep (0.4)
		print ("\033[1;35m<<<---welcome to Text to SHA384 converter--->>>"); wait()
		print ("\n"); wait()
		mystring = input("\033[4;2;37mTSc \033[0;0;0m> \033[1;31m(Enter your text)> ")
		hash_obj = hashlib.sha384(mystring.encode())
		print ("\033[4;2;37mTSc \033[0;0;0m> \033[1;34m(Result)>",(hash_obj.hexdigest())); wait()
		print ("\n")
		time.sleep (0.4)
		read = input("\033[4;2;37mTSc \033[0;0;0m> \033[1;36m>>(choose '1' To open the program again and any other button to exit)> ")
		if (read == '1'):
			print ("\033[4;2;37mTSc \033[0;0;0m> \033[1;32mrestarting the program"); wait()
			print ("\n"); wait()
			print ("\n")
			time.sleep (1)
		else:
			exit()
	elif (optn == '6'):
		time.sleep (0.4)
		print ("\033[1;35m<<<---welcome to Text to SHA512 converter--->>>"); wait()
		print ("\n"); wait()
		mystring = input("\033[4;2;37mTSc \033[0;0;0m> \033[1;31m(Enter your text)> ")
		hash_obj = hashlib.sha512(mystring.encode())
		print ("\033[4;2;37mTSc \033[0;0;0m> \033[1;34m(Result)>",(hash_obj.hexdigest())); wait()
		print ("\n")
		time.sleep (0.4)
		read = input("\033[4;2;37mTSc \033[0;0;0m> \033[1;36m>>(choose '1' To open the program again and any other button to exit)> ")
		if (read == '1'):
			print ("\033[4;2;37mTSc \033[0;0;0m> \033[1;32mrestarting the program"); wait()
			print ("\n"); wait()
			print ("\n")
			time.sleep (1)
		else:
			exit()
	elif (optn == 'back'):
		exit()

	elif (optn == '7'):
		time.sleep (0.4)
		print("\033[1;35m <<<--------welcome to text to  base64 convrter------>>>\033[0m\n"); wait()
		message =  input("\033[4;2;37mCSF\033[0;0;0m > \033[1;31mEnter your text---> \033[0m")
		message_bytes = message.encode('ascii'); wait()
		base64_bytes = base64.b64encode(message_bytes); wait()
		base64_message = base64_bytes.decode('ascii'); wait()
		print("\033[4;2;37mCSF\033[0;0;0m > \033[1;34mResult---> ",(base64_message)); wait()
		print ("\n")
		time.sleep (0.4)
		read = input("\033[4;2;37mCSF\033[0;0;0m > \033[1;36m>>choose '1' To open the program again and any other button to exit-->")

		if (read == '1'):
			print ("\033[4;2;37mCSF\033[0;0;0m > \033[1;32mrestarting the program"); wait()
			print ("\n"); wait()
			print ("\n")
			time.sleep (1)
		else:
			exit()
	elif (optn =='8'):
		time.sleep (0.4)
		print("\033[1;35m <<<--------welcome to text to  base32 convrter------>>>\033[0m\n"); wait()
		message =  input("\033[4;2;37mCSF\033[0;0;0m > \033[1;31mEnter your text---> \033[0m")
		message_bytes = message.encode('ascii'); wait()
		base32_bytes = base64.b32encode(message_bytes); wait()
		base32_message = base32_bytes.decode('ascii'); wait()
		print("\033[4;2;37mCSF\033[0;0;0m > \033[1;34mResult---> ",(base32_message)); wait()
		print ("\n")
		time.sleep (0.4)
		read = input("\033[4;2;37mCSF\033[0;0;0m > \033[1;36m>>choose '1' To open the program again and any other button to exit-->")
		if (read == '1'):
			print ("\033[4;2;37mCSF\033[0;0;0m > \033[1;32mrestarting the program"); wait()
			print ("\n"); wait()
			print ("\n")
			time.sleep (1)
		else:
			exit()
	elif (optn == 'back'):
		exit()
	else:
		print ("\n"); wait()
		print ("\033[4;2;37mTSc \033[0;0;0m> ERROR::-)> Try again with valid option"); wait()
