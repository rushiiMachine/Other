total = 0
while True:
    print('the total is:',total)
    try:
        total += int(input('Give me an integer! '))
    except:
        print('that was not an integer')