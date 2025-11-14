class PomBensin:
    def __init__(self):
        self.bensin = [
            Super(),
            Vpower(),
            Vpower_Nitro()
            ]

class Bensin():
    def __init__(self, harga, nama):
        self.harga = harga
        self.nama = nama

    def hitung_liter(self, liter):
        return self.harga*liter

    def hitung_rupiah(self, rupiah):
        return rupiah/self.harga

class Super(Bensin):
    def __init__(self):
        super().__init__(12000, "Super Ron 92")

    def hitung_liter(self, liter):
        return super().hitung_liter(liter)

    def hitung_rupiah(self, rupiah):
        return super().hitung_rupiah(rupiah)

class Vpower(Bensin):
    def __init__(self):
        super().__init__(13500, "V-Power Ron 95")

    def hitung_liter(self, liter):
        return super().hitung_liter(liter)

    def hitung_rupiah(self, rupiah):
        return super().hitung_rupiah(rupiah)
    
class Vpower_Nitro(Bensin):
    def __init__(self):
        super().__init__(14000, "V-Power Nitro+ Ron 98")

    def hitung_liter(self, liter):
        return super().hitung_liter(liter)

    def hitung_rupiah(self, rupiah):
        return super().hitung_rupiah(rupiah)
    
class Vpower_Diesel(Bensin):
    def __init__(self):
        super().__init__(14100, "V-Power Diesel CN 51")

    def hitung_liter(self, liter):
        return super().hitung_liter(liter)

    def hitung_rupiah(self, rupiah):
        return super().hitung_rupiah(rupiah)


def customInput(teks, min, max):
    while True:
        try:
            user = float(input(teks))
            if user < min or user > max:
                print(f"Mohon untuk memasukkan angka antara {min} dan {max}.")
                continue
            return user
        
        except ValueError:
            print("Input tidak valid. Mohon masukkan angka saja.")

def main():
    pb = PomBensin()

    while True:
        print("==== Selamat Datang di SPBU Shell ====")
        print("Pilihan jenis bensin:")
        print("1. Super Ron 92")
        print("2. V-Power Ron 95")
        print("3. V-Power Nitro+ Ron 98")
        print("4. V-Power Diesel CN 51")

        pilihan = int(customInput("Jenis bensin (1, 2, 3, 4): ", 1, 4))

        b = pb.bensin[pilihan-1]
        print(f"\nJenis Bensin: {b.nama}")
        print(f"Harga: Rp{b.harga:,}/liter")
        print("\nPilihan perhitungan:")
        print("1. Berdasarkan liter")
        print("2. Berdasarkan Rupiah")

        perhitungan = int(customInput("Perhitungan (1, 2): ", 1, 2))

        if perhitungan == 1:
            print("\nMenghitung berdasarkan liter")
            liter = customInput("Jumlah liter: ", 0.1, 1000)
            total = b.hitung_liter(liter)
            print(f"Liter bensin: {liter} liter")
            print(f"Total: Rp{total:,}")
            print(f"Anda telah membeli {b.nama} sebanyak {liter} liter dengan total Rp{total:,}")

        elif perhitungan == 2:
            print("\nMenghitung berdasarkan Rupiah")
            jRupiah = customInput("Jumlah Rupiah: ", 1, 100000000)
            total = b.hitung_rupiah(jRupiah)
            print(f"Liter bensin: {total:.2f}")
            print(f"Total: Rp{jRupiah:,}")
            print(f"Anda telah membeli {b.nama} seharga Rp{jRupiah:,} untuk {total:.2f} liter bensin")

        selesai = input("\nIngin melakukan transaksi lagi? (y/n): ").lower()
        if selesai != "y":
            print("Terima kasih sudah mengisi bensin di Shell, selamat jalan dan selamat sampai tujuan!")
            break

main()




