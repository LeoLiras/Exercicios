import random

a = [[random.randint(1, 9) for col in range(3)] for lin in range(3)]
b = [[val ** 2 for val in lin] for lin in a]

print(a)
print(b)
