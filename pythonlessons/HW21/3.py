from os.path import join, abspath, dirname

my_dir = abspath(dirname(__file__))
my_file = join(my_dir, 'practice.txt')
f = open(my_file, 'r')

line = f.readline()
while line != "":
  line = line.rstrip()
  print(line)
  print("length:",len(line),' last character:',line[-1])
  line = f.readline()

f.close()