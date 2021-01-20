def check_combination(digits):
    combo = str(digits)
    if len(combo)==6 and combo[0]==combo[-1] and int(combo[3])%2==0 and int(combo[4])+int(combo[5])==10:
        return True
    else:
        return False
print(check_combination(1234567))
print(check_combination(44))
print(check_combination(223582))
print(check_combination(111291))