def decode(encrypted):
    is_odd = len(encrypted)%2
    first_half = ''
    seconds_half = ''
    new = ''
    if is_odd:
        pass
    else:
        first_half=encrypted[:len(encrypted)//2]
        seconds_half=encrypted[len(encrypted)//2:]
    
    return seconds_half
print(decode('mciosmspiloins haecd'))
#             mciosmspiloins haecd