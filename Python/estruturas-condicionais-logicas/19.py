valor = 11

if valor % 5 == 0 and not valor % 3 == 0:
    print(f'{valor} é divisível somente por 5.')
elif not valor % 5 == 0 and valor % 3 == 0:
    print(f'{valor} é divisível somente por 3.')
elif valor % 5 == 0 and valor % 3 == 0:
    print(f'{valor} é divisível tanto por 5 quanto por 3.')
else:
    print(f'{valor} não é divisível nem por 5 nem por 3.')
