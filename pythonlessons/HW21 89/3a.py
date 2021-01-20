def is_binary(string):
    for digit in string:
        if digit not in "01":
            return False
    return True

print(is_binary('123'))
print(is_binary('001a1001'))
print(is_binary('1100010101111'))
print(is_binary('000001'))
