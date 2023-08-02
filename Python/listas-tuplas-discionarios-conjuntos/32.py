conj1 = set([1, 2, 3, 4, 5, 6])
conj2 = set([5, 4, 3, 2, 1, 7])

lista1 = list(conj1)
lista2 = list(conj2)

soma = 0
mult = 0

for index, val in enumerate(lista1):
    soma = soma + (lista1[index] + lista2[index])

print(f'Soma: {soma}')

for index, val in enumerate(lista1):
    mult = mult + (lista1[index] * lista2[index])

print(f'Multiplicação: {mult}')

diff = conj1.difference(conj2)
print(f'Diferença: {diff}')

interc = conj1.intersection(conj2)
print(f'Intersecção: {interc}')

uni = conj1.union(conj2)
print(f'União: {uni}')
