import math


cateto_o = float(input('Insira o cateto oposto do triângulo: '))
cateto_a = float(input('Insira o cateto adjascente do triângulo: '))

hip = math.sqrt(pow(cateto_o, 2) + pow(cateto_a, 2))

print(f'A hipotenusa é = {hip}')
