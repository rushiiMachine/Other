def encode(plaintext):
    encrypted = ''
    for letter in plaintext:
        if letter=='a':
            encrypted += 'e'
        elif letter=='o':
            encrypted += 'a'
        elif letter=='e':
            encrypted += 'o'
        else:
            encrypted += letter
    return encrypted
def decode(encrypted):
    plaintext = ''
    for letter in encrypted:
        if letter=='e':
            plaintext += 'a'
        elif letter=='a':
            plaintext += 'o'
        elif letter=='o':
            plaintext += 'e'
        else:
            plaintext += letter
    return plaintext
print(encode('bob was here'))
print(encode('equation'))
print(decode(encode('yeet')))