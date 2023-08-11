string1 = 'Olá'
string2 = 'Oi'


def iguais(strin1, strin2):
    contador = 0
    list(strin1)
    list(strin2)

    for ind, val in enumerate(list(strin1)):
        if len(strin1) != len(strin2):
            return False
        elif strin1[ind] == strin2[ind]:
            contador += 1

    if contador == len(strin1):
        return True
    else:
        print(contador)
        print(len(strin1))
        return False


print(iguais(string1, string2))
