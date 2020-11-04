from os.path import join, abspath, dirname

my_dir = abspath(dirname(__file__))
my_file = join(my_dir, 'practice.txt')
f = open(my_file, 'r')

lines = f.readlines()
print(lines)
print(len(lines))

f.close()