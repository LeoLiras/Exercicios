valor = int(input('Insira um valor: '))

print(f'Números naturais ímpares de {valor} até 0, em ordem decrescente: ')

for n in range(valor, -1, -1):
    if n % 2 == 1:
        print(f'{n} ', end=' ')
