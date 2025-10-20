menu = {
    "nasi goreng": 15000,
    "mie goreng": 12000,
    "sate ayam": 20000
}

orders = []
print("Selamat datang di sistem pemesanan")
u = 1

while(u == 1):
    m = input("Masukkan pesanan anda: ")
    n = int(input("Berapa jumlahnya: "))
    orders.append([m, n])

    p = int(input("Sudah selesai? (1: selesai, 2: belum): "))
    
    if(p == 1):
        break

jumlahOrder = 0
totalPembelian = 0
print("\n\n----Nota Pembelian----")

for i in orders:
    total = 0
    item = i[0]
    qty = int(i[1])
    if item in menu:
        total += menu[item] * qty

    totalPembelian += total
    jumlahOrder += qty
    print(f"{i[0]} x{i[1]} = {total}")

print(f"Jumlah item: {jumlahOrder}" )
print(f"Total pembayaran: {totalPembelian}")
