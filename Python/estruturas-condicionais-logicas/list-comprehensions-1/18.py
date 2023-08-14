import random

num = 5
lista = [random.randint(1, 50) for val in range(10)]
multipl = [val for val in lista if val % num == 0]

print(lista)
print(multipl)
print(len(multipl))
