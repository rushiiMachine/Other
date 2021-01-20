def isUppercase(word):
    uppercase="ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    if word[0] in uppercase:
        return True
    else:
        return False

print(isUppercase(input('Give me a word to see if its uppercase! ')))