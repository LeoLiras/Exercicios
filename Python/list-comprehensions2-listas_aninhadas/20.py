import random

matriz = [[random.randint(1, 2) for col in range(6)] for lin in range(3)]
soma = [val for lista in matriz for ind, val in enumerate(lista) if ind % 2 != 0]


for lista in matriz:
    for val in lista:
        print(val, end=' ')
    print()

print(sum(soma))
print(media)
