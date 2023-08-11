def soma_entre(num1=1, num2=100):
    soma = 0

    for n in range((num1 + 1), num2):
        print(f'{n} - ', end='')
        soma += n

    print()
    print(soma)

soma_entre()

