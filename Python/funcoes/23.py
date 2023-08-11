def tri_lat(val):
    contador = 1

    while contador <= val:
        for n in range(contador):
            print('*', end='')
        print()
        contador += 1

    contador = val

    while contador >= 1:
        for n in range(contador - 1):
            print('*', end='')
        print()
        contador -= 1

tri_lat(10)
