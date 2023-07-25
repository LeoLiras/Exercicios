seg = 1800
h = seg // 60 // 60
min = seg - (h * 60 * 60)
seg = seg - (min * 60) - (h * 60 * 60)

print(f'{h}:{min}:{seg}')
