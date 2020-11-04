import random
colors = ['White','Yellow','Blue','Red','Green','Black','Brown','Azure','Ivory','Teal','Silver','Purple','Navy blue','Pea green','Gray','Orange','Maroon','Charcoal','Aquamarine','Coral','Fuchsia','Wheat','Lime','Crimson','Khaki','Hot pink','Magenta','Olden','Plum','Olive','Cyan']
nouns = ['pillow','sock','bus','frog','car','bycicle','computer','bed','plane','scooter','paper','book','log','tree','leaf','charcoal','grill','stove','lava lamp','microwave','refrigirator','freezer','timer','clock','towel','shelf','calendar','phone','chocolate bar','christmas lights','bell','monitor','couch']
adjectives = ['smelly','grumpy','loud','delicious','jumpy','fast','speedy','disgusting','slow']
for i in range(5):
    print('I got a',colors[random.randint(0,len(colors)-1)],nouns[random.randint(0,len(nouns)-1)],'for New Year. It was',adjectives[random.randint(0,len(adjectives)-1)])