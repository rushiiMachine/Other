def starts_with_p_partA(string):
    if string[0]=='p':
        return True
    else:
        return False
def starts_with_p_partB(string):
    if string[0].lower()=='p':
        return True
    else:
        return False
print(starts_with_p_partA('Paris'))
print(starts_with_p_partA('pinwheel'))
print(starts_with_p_partA('apple'))

print(starts_with_p_partB('Paris'))
print(starts_with_p_partB('pinwheel'))
print(starts_with_p_partB('apple'))

def wordlist_starts_with_p(words):
    total = 0
    for word in words:
        if word.lower()[0]=='p':
            total += 1
    return total
print(wordlist_starts_with_p(['apple','Paris','pineapple','zebra','pottery']))
print(wordlist_starts_with_p(['Python','rattlesnake','cobra']))