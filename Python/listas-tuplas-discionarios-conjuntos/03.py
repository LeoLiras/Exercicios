valores = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
valores_quadrado = []

for valor in valores:
    valores_quadrado.append(valor ** 2)

for n in range(10):
    print(f'{valores[n]} -> {valores_quadrado[n]}')
