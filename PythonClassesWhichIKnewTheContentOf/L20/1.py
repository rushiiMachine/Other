# before = [1,2,3]
before = [9,11,4,5]
num = max(before[0],before[-1])
for i in range(len(before)):
    before[i] = num
print(before)
    