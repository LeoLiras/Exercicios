import random

matriz = [[random.randint(1, 9) for val in range(3)] for listas in range(3)]
soma = [val for ind1, listas in enumerate(matriz) for ind2, val in enumerate(listas) if ind1 > ind2]

for lista in matriz:
    for val in lista:
        print(val, end=' ')
    print()

print(sum(soma))
