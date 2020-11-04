def num_vowels(S):
    vowels = ['a','e','i','o','u']
    total = 0
    for letter in S:
        if letter.lower() in vowels:
            total += 1
    return total
print(num_vowels('mother'))
print(num_vowels('OutStAnding'))