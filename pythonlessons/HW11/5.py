import turtle
colors = ['red','orange','pink','green','purple']
pen = turtle.Pen()
for colorIndex in range(1, len(colors)+1):
    pen.color(colors[colorIndex-1])
    pen.begin_fill()
    for i in range(4):
        pen.forward(colorIndex*10)
        pen.left(90)
    pen.end_fill()
    pen.forward(colorIndex*10)
turtle.mainloop()