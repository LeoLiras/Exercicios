valores = [1234, 15425, 357, 2468, 18964, 7853, 94347, 154324, 15764, 999999999]
posicao = 0
maior = -99999999999999

for indice, val in enumerate(valores):
    if val > maior:
        maior = val
        posicao = indice

print(f'O maior valor da lista é: {maior}, na posição {posicao}.')


