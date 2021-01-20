from os.path import join, abspath, dirname

wd = abspath(dirname(__file__))
f = open(join(wd,'compressed_pic.txt'),'r')

lines = f.readlines()

for line in lines:
  index = 0
  while index<len(line)-1:
    print(line[index+1]*int(line[index]), end='')
    index += 2
  print('')

# finished