def is_intresting(word):
    if word.lower() == 'intresting':
        return True
    if 'x' in word.lower() and 'y' in word.lower():
        return True
    if word[0].lower() == word[-1].lower():
        return True
    return False
print(is_intresting('INTREsting'))
print(is_intresting('Madam'))
print(is_intresting('Sir'))
print(is_intresting('Xylophone'))
print(is_intresting('Box'))