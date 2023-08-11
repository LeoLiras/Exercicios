import random

def rand(lista):
    val = range(0, 5)
    embaralhados = list(val)
    random.shuffle(embaralhados)

    lista_nova = [embaralhados[i] for i in range(len(val))]

    return lista_nova


print(rand([]))
