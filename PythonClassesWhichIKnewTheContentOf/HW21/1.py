from os.path import join, abspath, dirname

my_dir = abspath(dirname(__file__))
my_file = join(my_dir, 'practice.txt')
f = open(my_file, 'r')

print(f.read())

f.close()