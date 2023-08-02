valores = [10, 20, 30, 40, 50, 60, 70, 80]

x = -1
y = -1

while not -1 < x < 8:
    x = int(input('Insira um valor inteiro X entre 0 e 7: '))

while not -1 < y < 8:
    y = int(input('Insira um valor inteiro Y entre 0 e 7: '))

print(f'A soma dos valores armazenados nos índices {x} e {y} é igual a: {valores[x]} + {valores[y]} = {valores[x] + valores[y]}')
