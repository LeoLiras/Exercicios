num = 2

def switch(num):
    switcher = {
        1: "Domingo",
        2: "Segunda",
    }
    return switcher.get(num, "Não encontrei o dia correspondente.")

print(switch(num))


