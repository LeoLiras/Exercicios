import random

num1 = random.randint(1, 100)
num2 = random.randint(1, 100)

res = int(input(f'Resolva a soma: {num1} + {num2}\n'))

if res == (num1 + num2):
    print('Resposta correta!')
else:
    print(f'Resposta incorreta! A resposta correta é: {num1 + num2}')
