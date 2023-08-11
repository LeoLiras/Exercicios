def e_triangulo(a, b, c):
    if a < (b + c) and b < (a + c) and c < (a + b):
        tipo_triangulo(a, b, c)
    else:
        return print('Não é triângulo.')


def tipo_triangulo(a, b, c):
    if a == b == c:
        return print('Triângulo equilátero.')
    elif a == b != c or a == c != b or b == c != a:
        return print('Triangulo isósceles.')
    elif a != b != c:
        return print('Triangulo escaleno.')


e_triangulo(9, 5, 5)
