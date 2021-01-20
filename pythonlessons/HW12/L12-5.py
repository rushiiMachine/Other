def bishops_attack(r1,c1,r2,c2):
    if abs(r1-r2)==abs(c1-c2):
        print('Yes')
    else:
        print('No')
bishops_attack(2,2,7,7)
bishops_attack(5,2,1,6)
bishops_attack(6,7,2,6)