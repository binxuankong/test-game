from collections import Counter
from adventure import Adventure
from monster import Monster
from mechanics import *

a = Adventure('Adam')
b = Adventure('Bob')
c = Adventure('Caleb')
d = Adventure('Daniel')

ds = [(a, a.speed), (b, b.speed), (c, c.speed), (d, d.speed)]
x = []
v1 = [0.2, 0.225, 0.25, 0.275, 0.3]
v2 = [0.2, 0.225, 0.25, 0.275, 0.3]

for v1v in v1:
    for v2v in v2:
        x = []
        for i in range(100):
            xx, ds = speed_calculate(ds, v1v, v2v)
            x.append(xx)
        print("{}, {}: {}".format(v1v, v2v, Counter(x)))