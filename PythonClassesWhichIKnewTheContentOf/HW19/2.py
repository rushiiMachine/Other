string = input('Gimme a string! ')
if 'a' in string.lower():
    print(string[string.index('a')+1:])
