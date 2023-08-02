import sys

valores = [1, 2, 3, 4, 5]

opt = int(input('Insira uma opção: \n[0] - Finalizar\n[1] - Ordem direta\n[2] - Ordem inversa\n'))

if opt == 1:
    print(valores)
elif opt == 2:
    valores.reverse()
    print(valores)
elif opt == 0:
    sys.exit()
else:
    print('Código inválido.')

