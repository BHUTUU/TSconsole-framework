#!/bin/python
import sys, os, time
def load_animation():
    load_str = "starting TSconsole framework console..."
    ls_len = len(load_str)
    animation = "|/-\\"
    anicount = 0
    counttime = 0
    i = 0
    while (counttime != 100):
        time.sleep(0.075)
        load_str_list = list(load_str)
        x = ord(load_str_list[i])
        y = 0
        if x != 32 and x != 46:
            if x>90:
                y = x-32
            else:
                y = x + 32
            load_str_list[i]= chr(y)
        res =''
        for j in range(ls_len):
            res = res + load_str_list[j]
        sys.stdout.write("\r\033[37m"+res +"\033[34m"+animation[anicount]+"   ")
        sys.stdout.flush()
        load_str = res
        anicount = (anicount + 1)% 4
        i =(i + 1)% ls_len
        counttime = counttime + 1
    if os.name =="nt":
        os.system("cls")
    else:
        os.system("clear")
if __name__ == '__main__':
    load_animation()

