num = int(input('Insira um número: '))
contador1 = 0
contador2 = 0

print(f'Os {num} primeiros números ímpares são: ')

while contador1 < num:
    if contador2 %2 == 1:
        print(f'{contador2} ', end=' ')
        contador1 = contador1 + 1
    contador2 = contador2 + 1
