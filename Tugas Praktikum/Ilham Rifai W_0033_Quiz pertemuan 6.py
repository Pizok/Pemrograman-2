# Nama: Ilham Rifai Wahyudi
# NPM: 120510240033
# 
# Pilihan: No.1 (Enkapsulasi)

class MemberGYM:
    def __init__(self, pin, nama, saldo):
        self.__pin = pin
        self.nama = nama
        self.saldo = saldo

    # Fungsi tambahan untuk validasi pin
    def __validasi_pin(self, inputPin):
        if isinstance(inputPin, int):
            if inputPin == self.__pin:
                return True
        
        print("Pin salah! Silahkan mencoba lagi")
        return False

    def cek_saldo(self, pin):
        if MemberGYM.__validasi_pin(self, pin):
            print(f"Saldo tersisa: {self.saldo:,}")

    def tambah_deposit(self, jumlah):
        self.saldo += jumlah
        print(f"Saldo sebesar {jumlah:,} berhasil ditambahkan")
        MemberGYM.cek_saldo(self, self.__pin)

    def pakai_fasilitas(self, jumlah):
        if self.saldo < jumlah:
            selisih = jumlah - self.saldo
            print(f"Maaf saldo tidak mencukupi, silahkan menambah deposit {selisih:,} terlebih dahulu!")
        else: 
            self.saldo -= jumlah
            print(f"Saldo sebesar {jumlah:,} berhasil terpotong!")
            MemberGYM.cek_saldo(self, self.__pin)

member1 = MemberGYM(12345, "Ilham", 30000)

member1.cek_saldo(12344)
print("")
member1.cek_saldo(12345)
print("")
member1.pakai_fasilitas(6000)
print("")
member1.tambah_deposit(30000)
print("")
member1.pakai_fasilitas(60000)