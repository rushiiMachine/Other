bob = ['monopoly','ticket to ride','clue','battleship','set']
joe = ['clue','checkers','quiddler','blokus','monopoly','battleship']
newlist = []
for game in bob:
    if game in joe:
        newlist.append(game)
print(newlist)