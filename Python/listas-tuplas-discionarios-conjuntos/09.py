valores = []
contador = 1

while contador < 7:
    val = int(input(f'Insira um valor par {contador} / 6: '))

    if(val % 2 == 0):
        valores.append(val)
        contador = contador + 1

valores.reverse()

print(f'Ordem inversa dos valores lidos: {valores}')
