for n in range(1000, 10000):
    n = str(n)
    val1 = int(f'{n[0]}{n[1]}')
    val2 = int(f'{n[2]}{n[3]}')

    res = (val1 + val2) ** 2

    if(res == int(n)):
        print(res)
