valores = [1, -4, 1, -234, 2, 6, -123, -154, 1, 2]

for index, val in enumerate(valores):
    if val < 0:
        valores[index] = 0

print(valores)
