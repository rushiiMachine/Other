def remove_z(string):
    if string == '':
        return ''
    if string[0] == 'z':
        return remove_z(string[1:])
    return string[0] + remove_z(string[1:])
print(remove_z('zzabzz'))
print(remove_z('zigzag'))
print(remove_z('zzz'))

def Z_end(string):
    if string == '':
        return ''
    if string[0] == 'z':
        return Z_end(string[1:]) + string[0]
    return string[0] + Z_end(string[1:])
print(Z_end('zzfu'))
print(Z_end('zslzeezp'))
print(Z_end('zzhizz'))

