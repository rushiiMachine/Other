word = input("word? ")
half_amnt = int(int(input("amount of lines (has to be odd)? "))/2)

amnt = 0
descending = False

while (True):
    if (amnt == half_amnt-1):
        descending = True
    print((" "* amnt) + word)
    if (descending):
        amnt -= 1
        if (amnt < 0):
            break
    else:
        amnt += 1
        