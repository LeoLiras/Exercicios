conj1 = {1, 3, 5, 7, 3, 8, 9, 1, 2, 3}
conj2 = {2, 5, 6, 7, 8, 9, 0, 3, 1, 2}
prod = 1

lista1 = list(conj1)
lista2 = list(conj2)

for index, val in enumerate(lista1):
    soma = lista1[index] + lista2[index]
    prod = prod * soma

print(f'Conjunto 1: {conj1}')
print(f'Conjunto 2: {conj2}')
print(f'Produto escalar: {prod}')

print(type(conj1))
