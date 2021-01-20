import turtle, random

steps = 20

mike = turtle.Turtle()
canvas = turtle.Screen()
mike.shape("turtle")
mike.speed(0)
mike.up()

info = turtle.Turtle()
info.hideturtle()
info.speed(0)
info.up()

controls = turtle.Turtle()
controls.hideturtle()
controls.speed(0)
controls.up()
controls.goto(-400,-400)
controls.write('Controls:')
controls.goto(-400,-410)
controls.write('Space - Pen up/down')
controls.goto(-400,-420)
controls.write('Arrow keys - movement')
controls.goto(-400,-430)
controls.write('Z/X - change width')
controls.goto(-400,-440)
controls.write('R/G/B change color to Red, Green, or Blue')
controls.goto(-400, -450)
controls.write('Q - clear canvas')

def update_info():
  info.clear()
  info.goto(-400,500)
  info.write(('Pen Down: '+str(mike.isdown())), font=('Arial', 20, "normal"))
  info.goto(-400, 460)
  info.write(('Width: '+str(mike.pensize())), font=('Arial', 20, "normal"))

update_info()

def h_right():
  mike.setheading(0)
  mike.forward(steps)
def h_left():
  mike.setheading(180)
  mike.forward(steps)
def h_up():
  mike.setheading(90)
  mike.forward(steps)
def h_down():
  mike.setheading(270)
  mike.forward(steps)
def toggle_pen():
  if mike.isdown():
    mike.up()
  else:
    mike.down()
  update_info()
def clear_canvas():
  mike.clear()
def red():
  mike.color("red")
def green():
  mike.color("green")
def blue():
  mike.color("blue")
def increase_width():
  size = mike.pensize()
  if size < 20:
    mike.pensize(size+1)
  update_info()
def decrease_width():
  size = mike.pensize()
  if size > 1:
    mike.pensize(size-1)
  update_info()

canvas.onkey(h_right, "Right")
canvas.onkey(h_left, "Left")
canvas.onkey(h_up, "Up")
canvas.onkey(h_down, "Down")
canvas.onkey(toggle_pen, "space")
canvas.onkey(clear_canvas, "q")
canvas.onkey(red, "r")
canvas.onkey(green, "g")
canvas.onkey(blue, "b")
canvas.onkey(increase_width, "x")
canvas.onkey(decrease_width, "z")

canvas.listen()
turtle.mainloop()