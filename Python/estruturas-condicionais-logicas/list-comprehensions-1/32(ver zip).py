import random

lista1 = [random.randint(1, 9) for val in range(10)]
lista2 = [random.randint(1, 9) for val in range(10)]

print(lista1)
print(lista2)

lista3 = [val1 + val2 for val1 in lista1 for val2 in lista2]

print(f'Soma = {lista3}')

