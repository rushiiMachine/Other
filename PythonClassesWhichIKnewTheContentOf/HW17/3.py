def vowels_to_pluses(S):
    vowels = ['a','e','i','o','u']
    new = ''
    for letter in S:
        if letter.lower() in vowels:
            new += '+'
        else:
            new += letter
    return new
print(vowels_to_pluses('mother'))
print(vowels_to_pluses('OutStAnding'))