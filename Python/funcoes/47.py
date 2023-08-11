import random

matriz = [[random.randint(1, 50) for val in range(4)] for val in range(4)]

def maiores_dez(matr):
    valor = 10
    contador = 0

    for lista in matriz:
        for valor in lista:
            if valor > 10:
                contador += 1

    return contador

print(matriz)
print(maiores_dez(matriz))
