from datetime import datetime
import calendar
import locale

def data(data_atual):
    locale.setlocale(locale.LC_TIME, 'pt_BR.utf8')

    mes = int(data_atual.split('/')[1])
    nome_mes = calendar.month_name[mes]
    print(f'{data_atual.split("/")[0]} de {nome_mes.title()} de {data_atual.split("/")[2]}')


data(datetime.now().date().strftime('%d/%m/%Y'))
