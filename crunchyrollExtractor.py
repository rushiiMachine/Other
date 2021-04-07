import os
import re
import subprocess
from datetime import datetime
from urllib.request import urlopen

from bs4 import BeautifulSoup

config = {
    "URL": "",
    "Command": "youtube-dl --write-sub --sub-lang enUS --embed-subs -f best",
    "DLAfterEditing": False,
    "DLFile": None,
    "RenameFilesAfterDL": False,
    "this_file_dir": os.path.dirname(os.path.realpath(__file__))
}

os.chdir(config["this_file_dir"])
links = []


def adjustConfig():
    global config
    config["URL"] = input('URL? ')

    cmd = input("Command to use? ")
    if cmd == '':
        print('Using default command: %s' % config["Command"])
    else:
        config["Command"] = cmd

    if input('Do download after extracting? y/n ').lower() == 'y':
        config["DLAfterEditing"] = True

    if config["DLAfterEditing"] == True and input('Rename file after downloading? y/n ').lower() == 'y':
        config["RenameFilesAfterDL"] = True


def extract():
    global config
    name = re.search(
        r"https?://www.crunchyroll\.com(/.+?(?=/|\?|$))", config["URL"])
    if name == None:
        print('Invalid URL')
        raise SystemExit
    name = name.group(1)
    soup = BeautifulSoup(urlopen(config["URL"]), features="html.parser")
    for a in soup.findAll('a'):
        video = re.search(name+r".+-\d{1,6}", a.get('href'))
        if not video == None:
            video = video.group(0)
            links.append('https://crunchyroll.com'+video)


def saveLinks():
    global config, links
    config["DLFile"] = os.path.join(
        config["this_file_dir"], datetime.now().strftime("%m-%d-%Y_%H-%M-%S.bat"))
    f = open(config["DLFile"], 'w+')
    f.write('REM Save this file after editing it then close it to do the download if you have that selected\n')
    for link in links:
        f.write("%s %s\n" % (config["Command"], link))
    f.write('PAUSE')
    f.close()
    notepad = subprocess.Popen(['notepad.exe', config["DLFile"]])
    notepad.wait()

    if config['DLAfterEditing']:
        os.system("start /B start cmd.exe @cmd /k %s" % config["DLFile"])
    if config["RenameFilesAfterDL"]:
        renamer()


def renamer():
    global config
    onlyfiles = [f for f in os.listdir(config["this_file_dir"]) if os.path.isfile(
        os.path.join(config["this_file_dir"], f))]
    for _file in onlyfiles:
        match = re.search('-\d{6}', _file)
        if match:
            found = match.group(0)
            renamedFile = _file.replace(found, "")
            os.rename(os.path.join(config["this_file_dir"], _file), os.path.join(
                config["this_file_dir"], renamedFile))


if __name__ == "__main__":
    adjustConfig()
    extract()
    saveLinks()
