def rhyme_rating(letters, word):
    total = 0
    for letter in letters:
        total += word.count(letter)
    return total
print(rhyme_rating('log','eggnog'))
print(rhyme_rating('log','blog'))
print(rhyme_rating('log','banana'))