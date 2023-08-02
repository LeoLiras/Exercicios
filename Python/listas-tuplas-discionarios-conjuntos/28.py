lista = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
impares = []
pares = []

for val in lista:
    if val %2 == 0:
        pares.append(val)
    else:
        impares.append((val))

print(f'Pares: {pares}')
print(f'Ímpares: {impares}')
