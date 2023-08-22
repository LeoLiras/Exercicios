import random

matriz = [[random.randint(1, 9) for val in range(3)] for lista in range(3)]
soma = [val for ind2, lista in enumerate(matriz) for ind1, val in enumerate(lista) if ind1 > ind2]

for lista in matriz:
    for val in lista:
        print(val, end=' ')
    print()

print(sum(soma))
