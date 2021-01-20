def binary_to_decimal(binary):
    total = 0

    reversedBinary = ""
    for i in reversed(binary):
        reversedBinary += i
    
    for i in range(len(reversedBinary)):
        total += int(reversedBinary[i]) * (2**i)
    
    return total

print(binary_to_decimal('11001'))