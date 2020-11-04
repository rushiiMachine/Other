def is_alphabetical(string):
    for index in range(len(string)):
        if index+1 == len(string):
            return True
        if string[index].lower() > string[index+1].lower():
            return False
print(is_alphabetical('aRt'))
print(is_alphabetical('effoRT'))
print(is_alphabetical('baby'))