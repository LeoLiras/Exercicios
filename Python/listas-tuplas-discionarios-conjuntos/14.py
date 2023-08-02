from collections import Counter

valores = [1, 2, 2, 4, 6, 7, 9, 10, 6 ,3, 5, 1]

count = Counter(valores)

for elemento, contagem in count.items():
    if contagem > 1:
        print(f'{elemento} -> {contagem} vezes.')



