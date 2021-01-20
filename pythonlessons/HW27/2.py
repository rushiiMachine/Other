L=[3,0,1,8,7,2,5,4,9,6]
M=[]
while len(L)!=0:
    num = min(L)
    L.remove(num)
    M.append(num)
print(M)