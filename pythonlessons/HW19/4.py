first = ['Bob','Ann','Cindy']
last = ['Brown','Smith','Campbell','Black']
names = []
for i in range(min(len(first),len(last))):
    names.append(first[i]+' '+last[i])
print(names)