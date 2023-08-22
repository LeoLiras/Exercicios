import random

lista = [random.uniform(-1, 1) for val in range(10)]
out = [val if val > 0 else 0 for val in lista]

print(lista)
print(out)
