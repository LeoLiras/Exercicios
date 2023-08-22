import random

matriz = [[random.randint(1, 9) for valores in range(3)] for listas in range(3)]
soma = [valores for ind1, listas in enumerate(matriz) for ind2, valores in enumerate(listas) if ind1 == ind2]

for lista in matriz:
    for val in lista:
        print(val, end=' ')
    print()

print(sum(soma))
