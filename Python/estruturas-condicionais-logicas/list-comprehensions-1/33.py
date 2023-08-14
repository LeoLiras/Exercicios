import random

lista = [random.randint(0, 9) for val in range(15)]
compact = [val for val in lista if val != 0]

print(lista)
print(compact)
