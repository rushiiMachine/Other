lst = [1,2,3,4,5,6,7,8,9,10]

index = 0
while index < len(lst):
    if lst[index]%2 == 0:
        lst.pop(index)
    else:
        index += 1

print(lst)