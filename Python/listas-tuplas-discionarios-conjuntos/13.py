valores = [1, 2, 3, 4, 5]
maior = -99999999999999999
menor = 999999999999999999
pos_maior = 0
pos_menor = 0

for index, val in enumerate(valores):
    if val > maior:
        maior = val
        pos_maior = index
    if val < menor:
        menor = val
        pos_menor = index

print(f'O maior valor lido foi {maior}, na posição {pos_maior}')
print(f'O menor valor lido foi {menor}, na posição {pos_menor}')
