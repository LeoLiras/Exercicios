for num in range(16):
    if num %3 == 0 and num != 0:
        print(f'{num} - ', end=(' '))
print('\n-------------------------------')

contador = 0
num = 0
while contador < 5:
    if num % 3 == 0 and num != 0:
        print(f'{num} - ', end=(' '))
        contador = contador + 1
    num = num + 1

