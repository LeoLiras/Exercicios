import random

matriz = [[1 if ind1 == ind2 else 0 for ind1, val in enumerate(range(5))] for ind2, lista in enumerate(range(5))]
print(matriz)
