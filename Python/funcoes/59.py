a = [1, 2, 3, 4, 5, 6, 7]
b = [2, 4, 6, 8, 721]


def uniao(vet1, vet2):
    c = vet1.union(vet2)
    print(vet1)
    print(vet2)
    print(c)


uniao(set(a), set(b))
