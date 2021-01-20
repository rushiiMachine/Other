def sum67(arr):
    section_ignored = False
    total = 0
    for item in arr:
        if item == 6:
            section_ignored = True
        if not section_ignored:
            total += item
        if item == 7:
            section_ignored = False
    return total

print(sum67([1,2,2]))
print(sum67([1,2,2,6,99,99,7]))
print(sum67([1,1,6,7,2]))
print(sum67([1,2,6,7,3,6,4,7,2]))
print(sum67([1,2,6,6,7]))