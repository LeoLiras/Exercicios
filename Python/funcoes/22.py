def linhas(val):
    contador = 1
    while contador <= val:
        for n in range(contador):
            print('!', end='')
        print()
        contador += 1

linhas(500)
