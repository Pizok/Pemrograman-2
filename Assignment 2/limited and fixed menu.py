"""
Kode untuk: 1. warung indomie with only limited and fixed menu

keterangan:
Menu yang ada = Mie rebus + sayur & telor, Mie goreng + sayur & telor, Mie goreng jumbo + sayur & telor (kode:1, 2, 3)
"""

"OOP"
class warung:
    def __init__(self, pilihanMenu):
        self.pilihan = pilihanMenu
        self.stepMasakRebus = ["Ambil bahan-bahan: sawi, telur, indomie", "Rebus air", "Masukkan telur", "Masukkan sawi dan mie", 
                          "Racik bumbu", "Tuang mie, sayuran, dan telur beserta air rebusan ke mangkok"]
        self.stepMasakGoreng = ["Ambil bahan-bahan: sawi, telur, indomie", "Rebus air", "Masukkan telur", "Masukkan sawi dan mie", 
                          "Racik bumbu", "Tiriskan air", "Tuang mie, sayuran, dan telur ke mangkok"]
        
    def masak(self):
        if self.pilihan == 1:
            for i in self.stepMasakRebus:
                print(i)
        else:
            for i in self.stepMasakGoreng:
                print(i)

"Procedural"

stepMasakRebus = ["Ambil bahan-bahan: sawi, telur, indomie", "Rebus air", "Masukkan telur", "Masukkan sawi dan mie", 
                  "Racik bumbu", "Tuang mie, sayuran, dan telur beserta air rebusan ke mangkok"]
stepMasakGoreng = ["Ambil bahan-bahan: sawi, telur, indomie", "Rebus air", "Masukkan telur", "Masukkan sawi dan mie", 
                   "Racik bumbu", "Tiriskan air", "Tuang mie, sayuran, dan telur ke mangkok"]

def ambilPesanan():
    pilihan = int(input("Menu: "))

def masak(menu):
    if menu == 1:
        for i in stepMasakRebus:
                print(i)
    else:
        for i in stepMasakGoreng:
            print(i)