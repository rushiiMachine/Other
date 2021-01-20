import turtle
pen = turtle.Pen()
pen.speed(0)

def triangle(side):
    for i in range(3):
        pen.forward(side)
        pen.left(120)
def hexagon(side):
    for i in range(6):
        pen.forward(side)
        pen.left(60)
def square(side):
    pen.right(90)
    pen.forward(side/2)
    pen.left(90)
    pen.forward(side)
    pen.left(90)
    pen.forward(side)
    pen.left(90)
    pen.forward(side)
    pen.left(90)
    pen.forward(side/2)
    pen.left(90)
def hexagon_flower(side):
    for i in range(8):
        hexagon(side)
        pen.left(45)
def square_flower(side):
    for i in range(10):
        square(side)
        pen.left(72)
def hexagon_using_triangles(side):
    for i in range(6):
        triangle(side)
        pen.left(60)

# Uncomment any of these to make shapes
hexagon_using_triangles(100)
# hexagon_flower(100)
# square_flower(100)

turtle.mainloop()