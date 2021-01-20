def is_fib_num(num):
    nums=[0,1]
    while nums[-1] <= num:
        nums.append(nums[-1]+nums[-2])
    if nums[-2] == num:
        return True
    return False
print(is_fib_num(55))
print(is_fib_num(56))
print(is_fib_num(54))
print(is_fib_num(1))
print(is_fib_num(610))