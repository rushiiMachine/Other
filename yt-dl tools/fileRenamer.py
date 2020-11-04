import re
import os
from os import listdir
from os.path import isfile, join

dir_path = os.path.dirname(os.path.realpath(__file__))
onlyfiles = [f for f in listdir(dir_path) if isfile(join(dir_path, f))]

for _file in onlyfiles:
    match = re.search('-\d{6}', _file)
    if match:
        found = match.group(0)
        renamedFile = _file.replace(found,"")
        print("'"+_file+"'",'->',"'"+renamedFile+"'")
        os.rename(join(dir_path, _file), join(dir_path, renamedFile))