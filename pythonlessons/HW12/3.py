words = ['trolley','car','cart','bus']
for i in range(len(words)-1):
    if words[i] == 'cart':
        words.insert(i,'horse')
print(words)