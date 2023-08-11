import math

def soma_alg(n):
    fatorial = list(str(math.factorial(n)))
    val = list(map(int, fatorial))

    return sum(val)


print(soma_alg(4))
