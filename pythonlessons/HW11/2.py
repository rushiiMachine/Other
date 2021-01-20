from random import randint
nums = [randint(1,10),randint(1,10),randint(1,10),randint(1,10),randint(1,10),randint(1,10)]
print(nums)
print(nums[0],nums[len(nums)-1])
for i in nums:
    print(i)
for i in nums:
    if i%2==1:
        print(i)