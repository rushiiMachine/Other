def flies(n):
    if n==0:
        return 50
    if n%2==1:
        return flies(n-1) + 7
    else:
        return flies(n-1) - 3

print(flies(1))
print(flies(2))
print(flies(6))