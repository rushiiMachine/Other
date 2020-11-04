# import turtle
# pen = turtle.Pen()
# pen.color("green")
# pen.up()
# pen.hideturtle()
# for i in range(5):
#     pen.stamp()
#     pen.forward(15)
# turtle.mainloop()

import turtle
pen = turtle.Pen()
colors = 'rrggbbbooh'
pen.up()
pen.hideturtle()
pen.goto(-200,0)
for color in colors:
    if color=='r':
        pen.color("red")
    elif color=='g':
        pen.color("green")
    elif color=='b':
        pen.color("blue")
    elif color=='o':
        pen.color("orange")
    else:
        pen.color("black")
    pen.stamp()
    pen.forward(15)

turtle.mainloop()