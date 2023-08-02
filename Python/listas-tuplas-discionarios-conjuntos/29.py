lista = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
pares = []
impares = []


for val in lista:
    if val %2 == 0:
        pares.append(val)
    else:
        impares.append(val)

print(f'Pares: {pares}, soma = {sum(pares)}')
print(f'Impares: {impares}, quantidade = {len(impares)}')
