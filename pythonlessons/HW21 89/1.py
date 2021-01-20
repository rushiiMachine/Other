from os.path import join, abspath, dirname

wd = abspath(dirname(__file__))
f = open(join(wd,'mystery_pic.txt'),'r')

lines = f.readlines()

decode_dict = {'a': ' ',
               'b': '_',
               'c': '/',
               'd': '\\',
               'e': '~',
               'f': '|',
               'g': '(',
               'h': 'o',
               'i': ')',
               'j': '^'}

for line in lines:
  for char in line:
    if char in decode_dict:
      print(decode_dict[char], end='')
  print('')