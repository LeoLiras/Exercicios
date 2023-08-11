matriz = [['M', 'A', 'C', 23], ['F', 'C', 'L', 34], ['M', 'C', 'P', 19],
        ['F', 'A', 'L', 35], ['F', 'C', 'P', 32]]


def leitura(matr):
    for lista in matr:
        for valor in lista:
            print(valor, end=' ')
        print()


def media(matr):
    soma = 0
    contador = 0

    for ind1, lista in enumerate(matr):
        if matr[ind1][1] == 'C' and matr[ind1][2] == 'P':
            soma += matr[ind1][3]
            contador += 1
    print(f'Média das idades de pessoas com olhos castnhos e cabelo preto: {soma / contador} ')

def maior_idade(matr):
    maior = -99999999999999

    for ind1, lista in enumerate(matr):
        for ind2, val in enumerate(lista):
            if matr[ind1][3] > maior:
                maior = matr[ind1][3]
    print(f'Maior idade encontrada: {maior}')


def quantidade(matr):
    quant = 0

    for ind1, lista in enumerate(matr):
        if matr[ind1][0] == 'F' and 18 <= matr[ind1][3] <= 35:
            if matr[ind1][1] == 'A' and matr[ind1][2] == 'L':
                quant += 1

    print(f'Quantidades de indivíduos do sexo feminino, de idade entre 18 e 35(inclusive), de olhos azuis e cabelos loiros: {quant}')

leitura(matriz)
print()
media(matriz)
print()
maior_idade(matriz)
print()
quantidade(matriz)

