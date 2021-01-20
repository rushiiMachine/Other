potion = int(input('How many ounces of potion do you have? '))
bottles = 0
while potion > 0:
    potion -= 12
    bottles += 1
print('You need',bottles,'12-oz vials')