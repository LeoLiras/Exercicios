a = [1, 3, 5, 7, 3, 8, 9, 1, 2, 3]
b = [2, 5, 6, 7, 8, 9, 0, 3, 1, 2]
c = []

for n in range(10):
    res = a[n] - b[n]
    c.append(res)

print(c)
