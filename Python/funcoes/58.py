import random

a = [[random.randint(1, 9) for _ in range(3)] for _ in range(3)]
b = [[random.randint(1, 9) for _ in range(3)] for _ in range(3)]


def produto(matriz1, matriz2):
    c = [[sum(matriz1[i][k] * matriz2[k][j] for k in range(len(matriz2))) for j in range(len(matriz2[0]))] for i in range(len(matriz1))]
    print(matriz1)
    print(matriz2)
    print(c)


produto(a, b)
