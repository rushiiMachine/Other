def letter_snatcher(word):
    for i in range(len(word),0,-1):
        print(word[:i])
letter_snatcher('Candy')