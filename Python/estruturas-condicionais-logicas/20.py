lado1 = 5
lado2 = 4
lado3 = 8

if lado1 < (lado2 + lado3) and lado2 < (lado1 + lado3) and lado3 < (lado1 + lado2):
    if lado1 == lado2 == lado3:
        print('O triângulo é equilátero.')
    elif lado1 == lado2 != lado3 or lado1 == lado3 != lado2 or lado3 == lado2 != lado1:
        print('O triângulo é isósceles.')
    elif lado1 != lado2 != lado3:
        print('O triângulo é escaleno.')
else:
    print('Não existe triângulo com esses lados.')
