import math

lista = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
primos = {}
e_primo = False

for index, val in enumerate(lista):
    for n in range(2, int(math.sqrt(val) + 1)):
        if not val %n == 0:
            primos[index] = val

for chave, valor in primos.items():
    print(f'Primo: {valor}, posição {chave}')
