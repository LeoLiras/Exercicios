a = [1, 3, 5, 7, 3, 8, 9, 1, 2, 3]
b = [2, 5, 6, 7, 8, 9, 0, 3, 1, 2]
c=[]

contador_a = 0
contador_b = 0

for n in range(20):
    if n %2 == 0:
        c.append(a[contador_a])
        contador_a = contador_a + 1
    else:
        c.append(b[contador_b])
        contador_b = contador_b + 1

print(a)
print(b)
print(c)
