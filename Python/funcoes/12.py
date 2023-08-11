def soma_algarismos(num):
    if num > 0:
        lista = list(str(num))
        lista = list(map(int, lista))
        print(lista)
        return print(f'Soma dos algarismos> {sum(lista)}')
    else:
        return print('Número inválido.')

soma_algarismos(251)
