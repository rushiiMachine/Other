string = input('Give me something! ')
swapped = string[len(string)//2:]+string[:len(string)//2]
print(swapped)