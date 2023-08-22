import random

matriz = [[random. randint(1, 9) for valores in range(4)] for listas in range(4)]
triangular_inferior = [[0 if ind1 > ind2 else val for ind1, val in enumerate(listas)] for ind2, listas in enumerate(matriz)]

for lista in matriz:
    for val in lista:
        print(val, end=' ')
    print()

print()

for lista in triangular_inferior:
    for val in lista:
        print(val, end=' ')
    print()
