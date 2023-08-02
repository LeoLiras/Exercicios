maior = -9999999999999999
menor = 99999999999999999

valores = [164, 1645, 12784, 12235, 12365, 67598, 37396, 8361237, 909530, 1238520]

for val in valores:
    if val > maior:
        maior = val
    if val < menor:
        menor = val

print(f'O maior valor lido foi: {maior}')
print(f'O menor valor lido foi: {menor}')
