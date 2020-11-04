def sum_digits(n):
    if n==0:
        return 0
    return sum_digits(n//10) + n%10

print(sum_digits(0))
print(sum_digits(23))
print(sum_digits(2471))