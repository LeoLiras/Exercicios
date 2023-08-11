import random

matriz = [[random.randint(1, 9) for colunas in range(6)] for linhas in range(7)]
n = 4


def soma(matr, coluna):
    som = [elemento for indice_linha, lin in enumerate(matriz)
            for indice_coluna, elemento in enumerate(lin) if indice_coluna == coluna]
    print(matriz)
    print(sum(som))


soma(matriz, n)
