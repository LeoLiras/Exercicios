import random

matriz = [[random.randint(1, 9) for val in range(3)] for val in range(3)]


def transposta(matr):
    transpost = [[matr[linha][coluna] for linha in range(len(matr))] for coluna in range(len(matr[0]))]

    return transpost


print(matriz)
print(transposta(matriz))
