integer = int(input('Give me an interger between 1 and 26: '))
alphabet = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
for i in range(integer):
    print(alphabet[i]*(i+1))