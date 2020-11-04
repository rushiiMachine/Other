def triangle(n):
    if n==1:
        return 1
    if n==0:
        return 0
    return triangle(n-1) + n

print(triangle(0))
print(triangle(1))
print(triangle(3))