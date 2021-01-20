def count_hi(string):
    if string=='':
        return 0
    if string[:2] == 'hi':
        return 1 + count_hi(string[2:])
    return count_hi(string[1:])
print(count_hi('ahibyehiz'))
print(count_hi('hi'))
print(count_hi('abc'))