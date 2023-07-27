import math

valor = 4
soma = int(1)
contador = 0

while contador < valor:
    soma = soma + (1 / math.factorial(int(soma)))
    contador = contador + 1

print(f'E = {soma}')
