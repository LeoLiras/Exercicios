valores = [1.23, 56, -2, 3, 12.67, 5, -9, -325,12.453, -54]
contador = 0
soma = 0

for valor in valores:
    if valor > 0:
        soma = soma + valor
    elif valor < 0:
        contador = contador + 1

print(f'Quantidade de números negativos: {contador}')
print(f'Soma dos números positivos: {soma}')
