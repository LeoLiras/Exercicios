import random

lista = [random.randint(1, 9) for val in range(10)]
pares = [val for val in lista if val % 2 == 0]

print(lista)
print(pares)
print(len(pares))
