def add_period(string):
    if string[-1] == '.':
        return string
    else:
        return string + '.'
print(add_period('I like cake'))
print(add_period('It\'s fluffy.'))