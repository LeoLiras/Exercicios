def quant(lista):
    contador = 0

    for val in lista:
        if val %2 == 0:
            contador += 1

    return contador


print(quant([1, 2, 3, 4, 5]))
