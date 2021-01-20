import os

with open(os.path.join(os.path.dirname(os.path.abspath(__file__)), 'birds.txt'),'r') as f:
    birdtxt = f.readlines()

birds = {}

for birdunstripped in birdtxt:
    bird = birdunstripped.rstrip()
    
    value = birds.get(bird, None)

    if not value == None:
        birds[bird] = value+1
    else:
        birds[bird] = 1

for bird in birds:
    print(bird, birds[bird])