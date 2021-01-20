def just_digits(S):
    new = ''
    for char in S:
        if char in "1234567890":
            new += char
    return new
print(just_digits("12 + 34 = 46"))