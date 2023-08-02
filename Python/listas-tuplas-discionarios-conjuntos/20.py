valores = []
contador = 1

while contador < 11:
    val = int(input(f'Insira um valor inteiro entre 0 e 50 ({contador} / 10): '))

    if 0 <= val <= 50:
        valores.append(val)
        contador = contador + 1

impares = []

for val in valores:
    if val % 2 == 1:
        impares.append(val)

print('Valores --- Ímpares')

for index, val in enumerate(valores):
    print(valores[index], end=' ')

    if index in range(len(impares)):
        print(f' --- {impares[index]}')

    else:
        print(f' --- X')
