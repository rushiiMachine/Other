words = ['apple','Paris','pineapple','zebra','buzz']
total = 0
for word in words:
    if 'z' in word.lower() or len(word) >= 6:
        print(word)
        total += 1
print('There are',total,'intresting words.')