import datetime
import sys
from InstagramPy import AppInfo
from .colors import *


class InstagramPyCLI():
    username = None
    started = None
    verbose = 0
    pService = None

    def __init__(self, appinfo, started, verbose_level, username, PortableService=None):
        self.pService = PortableService
        try:
            self.verbose = int(verbose_level)
            self.started = started
            self.username = username
            if not appinfo == None:
                appinfo = appinfo
        except:
            self.verbose = 0
            self.started = started
            appinfo = AppInfo.appInfo
            if username == None or username == '':
                self.ReportError("username not provided!")
            else:
                self.username = username

        self.HEADER = "{} {} , {}.\n\033[1;32mLet's hit and try the password! {} {} , {}.\n".format(appinfo['name'],
                                                                        appinfo['version'],
                                                                        appinfo['description'],
                                                                        appinfo['year'],
                                                                        appinfo['company'],
                                                                        appinfo['author'])
        self.HEADER = Fore.MAGENTA + self.HEADER + Style.RESET_ALL

    def ReportError(self, error):
        if self.pService is not None:
            if self.pService.isSetInstagramPyPortable():
                self.pService.terminate()
        print('{}{}\033[1;32m[\033[1;31m!\033[1;32m]\033[1;34mError::{} {}'.format(
            Style.BRIGHT, Fore.RED, Style.RESET_ALL, error))
        sys.exit(-1)

    def PrintHeader(self):
        print(self.HEADER)
        return True

    def PrintDatetime(self):
        print('{}[{}+{}{}]{} {}\033[1;33mStarted{} @ {}\033[0m'.format(Style.BRIGHT,
                                                      Fore.YELLOW,
                                                      Style.RESET_ALL,
                                                      Style.BRIGHT,
                                                      Style.RESET_ALL,
                                                      Fore.MAGENTA,
                                                      Style.RESET_ALL + Fore.YELLOW,
                                                      str(self.started) +
                                                      Style.RESET_ALL
                                                      ))
        return True

    def PrintChangingIP(self):
        print('\033[1;31m[{}*{}\033[1;31m] {}\033[1;35mChanging IP Address... {}\033[0m'.format(Fore.YELLOW,
                                                           Style.RESET_ALL, Fore.GREEN, Style.RESET_ALL))
        return True

    def PrintIPAddress(self, ip):
        print('\033[1;34m[{}\033[1;32m+{}\033[1;34m] {}\033[1;37mCurrent IP{} :: {}{}{}\033[0m'.format(Fore.RED,
                                                        Style.RESET_ALL,
                                                        Fore.YELLOW,
                                                        Style.RESET_ALL,
                                                        Style.BRIGHT,
                                                        str(ip),
                                                        Style.RESET_ALL
                                                        ))
        return True

    def PrintPassword(self, password):
        print('\033[1;32m[{}\033[1;35m+{}\033[1;32m] {}\033[1;32mTrying [FOR] @{} {} :: {}{}{}\033[0m'.format(Fore.GREEN,
                                                               Style.RESET_ALL,
                                                               Fore.CYAN,
                                                               self.username,
                                                               Style.RESET_ALL,
                                                               Style.BRIGHT,
                                                               password,
                                                               Style.RESET_ALL
                                                               ))
        return True

    def PrintRequest(self, req):
        print('\n\033[1;32m[{}\033[1;31m-{}\033[1;32m] --:: {}REQUEST START -> @{} {} ::--\033[0m'.format(Fore.MAGENTA,
                                                                     Style.RESET_ALL, Back.CYAN + Style.BRIGHT, self.username, Style.RESET_ALL))
        print('{}{}{} {}{}{}'.format(Fore.GREEN, req.method,
                                     Style.RESET_ALL, Style.BRIGHT, req.url, Style.RESET_ALL))
        print('{}{}{}'.format(Fore.YELLOW, '\n'.join('{}: {}'.format(k, v)
                                                     for k, v in req.headers.items()), Style.RESET_ALL))
        print('{}{}{}'.format(Style.BRIGHT, req.body, Style.RESET_ALL))
        print('\033[1;32m[{}\033[1;31m+{}\033[1;32m] --:: {}REQUEST   END{} ::--\033[0m'.format(Fore.GREEN,
                                                           Style.RESET_ALL, Back.GREEN + Style.BRIGHT, Style.RESET_ALL))
        return True

    def PrintResponse(self, resp):
        print('\033[1;36m\n[{}\033[1;33m!-!{}\033[1;36m] --:: {}\033[1;36mRESPONSE START -> @{} {} \033[1;31m::--\033[0m'.format(Fore.MAGENTA,
                                                                      Style.RESET_ALL, Back.CYAN + Style.BRIGHT, self.username, Style.RESET_ALL))
        print('{}{}{}'.format(Style.BRIGHT, str(resp), Style.RESET_ALL))
        print('\033[1;34m[{}\033[1;32m+{}\033[1;34m]\033[1;35m --:: {}\033[1;31mRESPONSE   END{} \033[1;34m::--\033[0m'.format(Fore.GREEN,
                                                            Style.RESET_ALL, Back.GREEN + Style.BRIGHT, Style.RESET_ALL))
        return True

    def PrintProgress(self, password, ip, request, response):
        if self.verbose == 0:
            self.PrintPassword(password)
        elif self.verbose == 1:
            self.PrintPassword(password)
            self.PrintResponse(response)
        elif self.verbose == 2:
            self.PrintPassword(password)
            self.PrintResponse(response)
            self.PrintIPAddress(ip)
        else:
            self.PrintPassword(password)
            self.PrintRequest(request)
            self.PrintResponse(response)
            self.PrintIPAddress(ip)
        return True

    def ReportAttack(self, password):
        print('\n\033[1;32m[\033[1;35m{}+{}\033[1;32m] --:: {}\033[1;32mCompleted -> @{} {} \033[1;33m::--\033[0m'.format(Fore.YELLOW,
                                                                 Style.RESET_ALL, Back.YELLOW + Style.BRIGHT, self.username, Style.RESET_ALL),
              end='')
        if not password == None:
            print('{}\033[1;33m[{}\033[1;31m✓{}{}\033[1;33m]{} {}\033[1;33mPassword Found!{}  :: {}\033[0m'.format(Style.BRIGHT,
                                                                    Fore.RED,
                                                                    Style.RESET_ALL,
                                                                    Style.BRIGHT,
                                                                    Style.RESET_ALL,
                                                                    Fore.CYAN,
                                                                    Style.RESET_ALL + Style.BRIGHT + Fore.GREEN,
                                                                    password + Style.RESET_ALL
                                                                    ))
        else:
            print('{}\033[1;32m[\033[1;31m!!{}\033[1;32m]\033[1;31mPassword not found , Try using another wordlist.{}\033[0m'.format(
                Style.BRIGHT, Fore.RED, Style.RESET_ALL))

        print('{}\033[1;31m[{}\033[1;35m+{}{}\033[31m]{} {}\033[1;32mFinnished in {}{}\033[0m'.format(Style.BRIGHT,
                                                         Fore.YELLOW,
                                                         Style.RESET_ALL,
                                                         Style.BRIGHT,
                                                         Style.RESET_ALL,
                                                         Fore.MAGENTA,
                                                         Style.RESET_ALL + Fore.YELLOW,
                                                         str(datetime.datetime.now(
                                                         ) - self.started) + Style.RESET_ALL
                                                         ))
        return True

    def PrintFooter(self):
        print('\n{}\033[1;35mGithub:->>{}{}\033[1;31mhttps://github.com/BHUTUU/IG-BHUTUU{}\033[0mm'.format(Fore.GREEN,
                                                                                                                      Style.RESET_ALL,
                                                                                                                      Style.BRIGHT,
                                                                                                                      Style.RESET_ALL
                                                                                                                      ))
        return True
