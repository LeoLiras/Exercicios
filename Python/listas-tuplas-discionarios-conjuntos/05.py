valores = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
pares = []
contador = 0

for val in valores:
    if val %2 == 0:
        contador = contador + 1;
        pares.append(val)

print(f'O vetor tem {contador} valores pares')
print(pares)
