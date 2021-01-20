L1 = ['donkey','apples','fly','pears','moose']
L2 = ['moose','donkey','fly']
for i in range(len(L1)):
    if L1[i] in L2:
        L1[i] = 'bananas'
print(L1)