val = 7
linha = 1
dig = 1
cont_dig = 0
tria = False

while tria == False:
    if linha == cont_dig:
        print('\n')
        linha = linha + 1
        cont_dig = 0
    elif linha == (val + 1):
        tria = True
    else:
        print(dig, end=' ')
        cont_dig = cont_dig + 1
        dig = dig + 1




