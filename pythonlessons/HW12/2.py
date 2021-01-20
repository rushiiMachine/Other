names = ['Joe','Anna','Max','Jenny']
max_pos = names.index('Max')
print('Max is number',max_pos+1,'in line')
if max_pos == 0:
    print('There is no one in front of him.')
else:
    print(names[max_pos-1],'is in front of him')
if max_pos == len(names)-1:
    print('He is the last in line')
else:
    print(names[max_pos+1],'is behind him')