maior = int(0)
contador = 0

for n in range(1, 4):
    valor = int(input(f'Insira um valor {n} / 3: '))
    if maior < valor:
        maior = valor
        contador = 1
    elif maior == valor:
        contador = contador + 1
print(f'Maior valor lido: {maior}')
print(f'Vezes em que o maior valor foi lido: {contador}')
