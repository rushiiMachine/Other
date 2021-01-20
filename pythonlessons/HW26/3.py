def has_7(array):
    if len(array) == 0:
        return False
    return True if array[0]==7 else has_7(array[1:])
print(has_7([1,4,8]))
print(has_7([7]))
print(has_7([1,7,8]))