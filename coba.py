class Coba:
    def __init__ (self, nama, umur):
        self.nama = nama
        self.umur = umur

    def ucapan(self):
        print(f"Hallo {self.nama}, umur: {self.umur} ")
    
orang = Coba("Ilham", 19)
orang.ucapan()
