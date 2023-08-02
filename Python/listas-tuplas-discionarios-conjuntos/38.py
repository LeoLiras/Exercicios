contador = 1
lista = []

while contador <= 10:
    val = float(input(f'Insira um valor {contador} / 10: '))
    lista.append(val)
    lista.sort()

    contador += 1

print(lista)
