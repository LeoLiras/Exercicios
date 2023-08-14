import random

lista = [random.uniform(-10, 10) for val in range(10)]
positivos = [val for val in lista if val > 0]
negativos = [val for val in lista if val < 0]

print(lista)
print(positivos)
print(sum(positivos))
print(negativos)
print(len(negativos))
