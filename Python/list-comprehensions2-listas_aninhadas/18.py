import random

matriz = [[random.randint(1, 9) for col in range(3)] for lin in range(3)]
lista = [sum(lin[ind_col] for lin in matriz) for ind_col in range(len(matriz[0]))]

print(matriz)
print(lista)
