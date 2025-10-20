#Dict untuk menu
menu = {
    "nasi goreng": 15000,
    "mie goreng": 12000,
    "sate ayam": 20000
}

orders = [] #List untuk pesanan pelanggan
print("Selamat datang di sistem pemesanan")
u = 1 #Variabel untuk true pada looping; kayaknya bisa pake True sih :)

#Looping untuk menambah pesanan
while(u == 1):
    m = input("Masukkan pesanan anda: ")
    n = int(input("Berapa jumlahnya: "))
    orders.append([m, n]) #Menambah pesanan dan jumlah ke list

    p = int(input("Sudah selesai? (1: selesai, 2: belum): "))
    
    if(p == 1): #Jika masukkan 1, program akan selesai
        break

jumlahOrder = 0 #Untuk nota pembelian
totalPembelian = 0 #Untuk nota pembelian
print("\n\n----Nota Pembelian----")

#Looping untuk menampilkan pesanan dan menjumlahkan harga
for i in orders:
    total = 0
    item = i[0]
    qty = int(i[1])
    if item in menu:
        total += menu[item] * qty #Assign total harga ke total

    totalPembelian += total #Menambahkan ke total
    jumlahOrder += qty #Menambahkan ke jumlah item
    print(f"{i[0]} x{i[1]} = {total}")

print(f"Jumlah item: {jumlahOrder}" )
print(f"Total pembayaran: {totalPembelian}")
