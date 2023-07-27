num = 33

for n in range(num, 100000):
    if n % 11 == 0:
        print(f'{n} é mútiplo de 11.')
        break
    elif n % 13 == 0:
        print(f'{n} é mútiplo de 13.')
        break
    elif n % 17 == 0:
        print(f'{n} é mútiplo de 17.')
        break
