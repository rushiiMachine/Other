list_ = [1,-24,1334,103,-77,-2]
for item in range(len(list_)):
    if list_[item]%2==0:
        list_[item] = 0
    else:
        list_[item] = 1
print(list_)
