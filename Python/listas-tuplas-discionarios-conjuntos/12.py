valores = [1, 2, 9, 10, 124]
maior = -999999999999999999999
menor = 99999999999999999999999
soma = 0

for val in valores:
    if val > maior:
        maior = val
    if val < menor:
        menor = val
    soma = soma + val

print(f'Maior valor lido: {maior} \nMenor valor lido: {menor} \nMédia dos valores lidos: {soma / 5}')
