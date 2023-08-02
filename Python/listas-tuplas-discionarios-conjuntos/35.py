x = 1234
y = 2454

lista1 = list(str(x))
lista1.reverse()
lista2 = list(str(y))
lista2.reverse()

num1 = int(''.join(str(digito) for digito in lista1))
num2 = int(''.join(str(digito) for digito in lista2))

lista3 = [(num1 + num2)]
print(lista3)
