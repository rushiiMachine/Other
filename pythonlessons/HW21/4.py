from os.path import join, abspath, dirname

my_dir = abspath(dirname(__file__))
my_file = join(my_dir, '4.txt')
f = open(my_file, 'r')

lines = f.readlines()
for i in lines:
    if len(i.rstrip()) >= 5:
        print(i.rstrip())

f.close()