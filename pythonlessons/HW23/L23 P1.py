import turtle
axis = turtle.Pen()
axis.speed(0)
axis.goto(-1000,0)
axis.goto(1000,0)
axis.goto(0,0)
axis.goto(0,1000)
axis.goto(0,-1000)

up_right = turtle.Pen()
up_left = turtle.Pen()
down_right = turtle.Pen()
down_left = turtle.Pen()
up_right.speed(0)
up_left.speed(0)
down_right.speed(0)
down_left.speed(0)
up_right.shape("turtle")
up_left.shape("turtle")
down_right.shape("turtle")
down_left.shape("turtle")
up_right.color("green")
up_left.color("blue")
down_right.color("red")
down_left.color("yellow")
up_right.width(3)
up_left.width(3)
down_right.width(3)
down_left.width(3)

window = turtle.Screen()

def up_right_click(x,y):
    up_right.goto(x,y)
    up_left.goto(x*-1,y)
    down_right.goto(x,y*-1)
    down_left.goto(x*-1,y*-1)
# def up_left_click(x,y):
#     pass
# def down_right_click(x,y):
#     pass
# def down_left_click(x,y):
#     pass

window.onclick(up_right_click)
# up_left.onclick(up_left_click)
# down_right.onclick(down_right_click)
# down_left.onclick(down_left_click)


turtle.mainloop()