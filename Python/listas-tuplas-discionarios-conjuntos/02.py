valores = []

for n in range(1, 7):
    val = int(input(f'Insira um valor {n} / 6: '))
    valores.append(val)

print('Valores lidos: ')

for valor in valores:
    print(f'{valor} - ', end=' ')
