words = ['car','truck','firetruck','mummy','table','helo']

def third_letter_is_m(s):
    return len(s) >= 3 and s[2].lower() == 'm'

print(list(filter(third_letter_is_m, words)))