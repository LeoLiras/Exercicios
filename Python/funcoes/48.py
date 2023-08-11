import random

matriz = [[random.randint(1, 9) for val in range(3)] for val in range(3)]

def soma_acima_dig_princip(matr):
    soma = 0

    for ind_a, lista in enumerate(matr):
        for ind_b, val in enumerate(lista):
            if ind_b > ind_a:
                soma += matr[ind_a][ind_b]

    print(soma)


for lista in matriz:
    for valor in lista:
        print(valor, end=' ')
    print()

soma_acima_dig_princip(matriz)
