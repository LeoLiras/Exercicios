import random

matriz = [[random.randint(1, 11) for val in range(3)] for lista in range(4)]
maiores_dez = [val for linha in matriz for val in linha if val > 10]
print(matriz)
print(maiores_dez)
