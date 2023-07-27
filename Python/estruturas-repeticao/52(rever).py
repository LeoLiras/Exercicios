saque = 650
saq = False
cont100 = 0
cont50 = 0
cont20 = 0
cont10 = 0
cont5 = 0
cont2 = 0
cont1 = 0

while((saque // 100) == 0):
        saque = saque - 100
        cont100 = cont100 + 1
        print(cont100)

while(saq == False):
    if (saque // 100) == 0:
        saque = saque - 100
        cont100 = cont100 + 1
        print(cont100)
    while(saque % 50 == 0):
        saque = saque - 50
        cont50 = cont50 + 1
    while(saque % 20 == 0):
        saque = saque - 20
        cont20 = cont20 + 1
    while(saque % 10 == 0):
        saque = saque - 10
        cont10 = cont10 + 1
    while(saque % 5 == 0):
        saque = saque - 5
        cont5 = cont5 + 1
    while(saque % 2 == 0):
        saque = saque - 2
        cont2 = cont2 + 1
    while(saque % 20 == 0):
        saque = saque - 1
        cont1 = cont1 + 1
    if(saque == 0):
        saq = True

print(f'Notas necessárias para o saque: \n')
print(f'Notas de 100: {cont100}\n Notas de 50: {cont50} \n Notas de 20: {cont20} \n Notas de 10: {cont10} \n Notas de 5: {cont5}'
      f'\n Notas de 2: {cont2} \n Notas de 1: {cont1}')
