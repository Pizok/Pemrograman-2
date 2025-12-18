from functools import reduce

#a. Map & Reduce
harga = [45, 12, 30, 22, 90, 5]
diskon = map(lambda x: x-(x*0.1), harga)
print(reduce(lambda x, y: x + y, diskon))

#b. Filter
nilaiMahasiswa = [90, 45, 77, 80, 55, 30, 100]
nilaiLulus = list(filter(lambda x: x >= 70, nilaiMahasiswa))
print(nilaiLulus)

#c. Transformasi
nama = ["amanda", "BOB", "daNiEL", "sArA"]
print([x.lower().capitalize() for x in nama])

