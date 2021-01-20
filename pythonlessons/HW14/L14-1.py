nums = [300,25,14,1000,100,3]
odd_nums = 0
negative_num = False
odd_total = 0
for num in nums:
    if num < 100 and num > 0:
        odd_nums += 1
print('There are',odd_nums,'numbers between 0 and 100')
for num in nums:
    if num < 0:
        negative_num=True
if negative_num:
    print('There is a negative number in the list')
else:
    print('There is no negative numbers in the list')
for num in nums:
    if num%2==1:
        odd_total += num
print('The total of the odd numbers in the list is',odd_total)