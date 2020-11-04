def sign(N):
    if N==0:
        return 2
    elif N > 0:
        return 1
    else:
        return 0
a = 3
b = 4
print(sign(a)+sign(b))