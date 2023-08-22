import random

matriz = [[random.randint(1, 9) for valores in range(3)] for listas in range(3)]
transposta = [[val for ind1, val in enumerate(lista)] for ind2, lista in enumerate(matriz)]

for lista in matriz:
    for val in lista:
        print(val, end=' ')
    print()

print()

for lista in transposta:
    for val in lista:
        print(val, end=' ')
    print()
