import turtle
pen = turtle.Pen()
pen.up()
pen.goto(200,-200)
pen.speed(0)

class Tree:
    def __init__(self, height, shape, color):
        self.height = height
        self.shape = shape
        self.color = color
    def print_info(self):
        print(self.height, self.shape, self.color)
    def draw(self):
        pen.color('brown')
        pen.down()
        pen.begin_fill()
        pen.fd(20)
        pen.left(90)
        pen.fd(self.height)
        pen.left(90)
        pen.fd(20)
        pen.left(90)
        pen.fd(self.height)
        pen.left(90)
        pen.fd(20)
        pen.end_fill()

        if self.shape == 'circle':
            pen.left(90)
            pen.fd(self.height)
            pen.left(90)
            pen.fd(10)
            pen.left(180)
            pen.color(self.color)
            pen.begin_fill()
            pen.circle(50)
            pen.end_fill()
        elif self.shape == 'triangle':
            pen.up()
            pen.goto(pen.pos()[0], pen.pos()[1]+self.height)
            pen.goto(pen.pos()[0]-100, pen.pos()[1])
            pen.color(self.color)
            pen.down()
            pen.begin_fill()
            pen.fd(220)
            pen.left(135)
            pen.fd(220)
            pen.left(90)
            pen.fd(220)
            pen.left(135)
            pen.end_fill()
            pen.up()
        
t1 = Tree(100,"circle", "red")
t2 = Tree(50,"triangle", "blue")
t3 = Tree(200,"circle", "yellow")
t4 = Tree(100,"triangle", "green")
t5 = Tree(50,"triangle", "orange")
t1.print_info()
t2.print_info()

t1.draw()

import random
for tree in [t1,t2,t3,t4,t5]:
    pen.up()
    pen.goto(random.randint(-300,300), 0)
    tree.draw()

turtle.mainloop()