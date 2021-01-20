invalid = []
while True:
    txt = input('Give me an integer! ')
    try:
        num = int(txt)
    except:
        print('that wasnt an integer!')
        invalid.append(txt)
    else:
        print('It took you',len(invalid)+1,'attempts to give me an integer')
        print(invalid,'Those are clearly not integers')
        break