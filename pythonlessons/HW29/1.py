class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y
    def dist_to_center(self):
        return abs(self.x)+abs(self.y)

pt1 = Point(3, 4)
print(pt1.dist_to_center())

pts = [pt1, Point(20,20), Point(40,10), Point(60,20), Point(80,10)]

biggest_dist = 0
for pt in pts:
    print(pt.dist_to_center())
    if pt.dist_to_center() > biggest_dist:
        biggest_dist = pt.dist_to_center()
print('biggest distance from 0,0 is:', biggest_dist)

import turtle
pen = turtle.Pen()
for i in range(10):
    pen.down()
    for pt in pts:
        pen.goto(pt.x-i, pt.y-i)
    pen.up()
turtle.mainloop()