lista = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

def par_imp(x):
    a = [val for val in x if val %2 == 0]
    b = [val for val in x if val %2 != 0]

    print(a)
    print(b)


par_imp(lista)
