lista = []
contador = 0
n = 0

while(contador < 100):
    if not n %7 == 0 or n %10 == 7:
        lista.append(n)
        contador = contador + 1
    n = n + 1

print(lista)
print(len(lista))
