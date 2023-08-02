lista = []
contador = 1
existe = False

while contador <= 10:
    val = int(input(f'Insira um valor inteiro {contador} / 10: '))

    for valor in lista:
        if valor == val:
            print(f'Insira somente valores diferentes.')
            existe = True
        else:
            existe = False

    if existe == False:
        lista.append(val)
        contador = contador + 1

print(lista)
