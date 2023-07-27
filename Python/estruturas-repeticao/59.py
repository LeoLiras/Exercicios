import sys

hab = 5
maior = -999999
menor = 9999999
soma_total = 0
soma_residencial = 0
soma_comercial = 0
soma_industrial = 0
soma = 0

for n in range(1 , (hab + 1)):
    cons = float(input(f'Insira o consumo mensal (KWh) {n} / 5: '))
    cod = int(input(f'Insira o código do consumidor {n} / 5: '))

    if 0 < cod < 4:
        soma = soma + cons

        if cons > maior:
            maior = cons
            maiorn = n
        elif(cons < menor):
            menor = cons
            menorn = n

        if(cod == 1):
            soma_residencial = soma_residencial + cons
        elif(cod == 2):
            soma_comercial = soma_comercial +cons
        elif(cod == 3):
            soma_industrial = soma_industrial + cons
    else:
        print(f'Código inválido.')
        sys.exit()

print(f'\nO maior consumo é o do consumidor {maiorn}: {maior} KWh')
print(f'O menor consumo é o do consumidor {menorn}: {menor} KWh')
print(f'Média de consumo de todos os habitantes: {soma / 5}')
print(f'Total de consumo por categoria (KWh): ')
print(f'1 - Residencial: {soma_residencial}')
print(f'2 - Comercial: {soma_comercial}')
print(f'3 - Industrial: {soma_industrial}')




