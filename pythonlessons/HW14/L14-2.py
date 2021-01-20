words = ['bread','peanut butter','bread','egg','ham']
pos = words.index('peanut butter')
if words[pos-1] == 'bread' and words[pos+1] == 'bread':
    print('We have a sandwich!')
else:
    print('We are missing some bread for a proper sandwich')
