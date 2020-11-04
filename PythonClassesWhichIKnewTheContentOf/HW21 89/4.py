from os.path import join, abspath, dirname
wd = abspath(dirname(__file__))
f = open(join(wd,'combinations.txt'),'r')
lines = f.readlines()

for line in lines:
    line = line.rstrip()
    if len(line)==6 and line[0]==line[2] and int(line[1])%2==0 and (int(line[3]) + int(line[4]) + int(line[5]))%7==0:
        print('YES')
    else:
        print('NO')
