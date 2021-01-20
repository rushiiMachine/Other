word = input('Give me a word: ')
lst = list(word)
for i in range(len(lst)):
    print(''.join(lst))
    lst.insert(0,lst[-1])
    lst.pop()
    