answer = int(input('Give me a number and i will add it to the total: '))
total = 0
while total <= 50:
    total += answer
    print('total =',total)
    if total <= 50:
        answer = int(input('Give me a number and i will add it to the total: '))
    else:
        print('That was over 50, too hard')
