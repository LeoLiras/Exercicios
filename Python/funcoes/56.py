import random

matriz = [[random.randint(1, 9) for colunas in range(6)] for linhas in range(7)]
n = 4

def soma(matriz, linha):
    soma = [elemento for indice_linha, lin in enumerate(matriz) if indice_linha == linha for elemento in lin]
    print(matriz)
    print(sum(soma))


soma(matriz, n)
