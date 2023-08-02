valores = [1, 2, 5, 7, 10, 11, 12, 15, 16, 18, 23, 35]
multiplos = []

x = int(input('Insira um valor inteiro: '))

for val in valores:
    if val % x == 0:
        multiplos.append(val)

print(f'Múltiplos de {x} encontrados: {multiplos}')

