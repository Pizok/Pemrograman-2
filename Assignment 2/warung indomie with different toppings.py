"""
Kode untuk: 2. warung indomie with different toppings

keterangan:
Menu yang ada = Mie rebus, Mie goreng, Mie goreng jumbo {kode: 1, 2, 3}
Topping = Sayur, Telur, Bakso, Sosis, Ayam, Cabe rawit
"""

"OOP"
class warung:
    def __init__(self, pilihanMie, pilihanTopping=[]):
        self.pilihan = pilihanMie
        self.topping = pilihanTopping
        self.stepMasakRebus = ["Ambil bahan-bahan: ", "Rebus air", "Masukkan topping", "Masukkan mie", 
                               "Racik bumbu", "Tuang mie dan topping beserta air rebusan ke mangkok"]
        self.stepMasakGoreng = ["Ambil bahan-bahan: ", "Rebus air", "Masukkan topping", "Masukkan mie", 
                                "Racik bumbu", "Tiriskan air", "Tuang mie dan topping ke mangkok"]
        
    def step(self, tipe=[]):
        for index, step in enumerate(tipe):
            print(step)
            if index == 0:
                print("indomie")
                for i in self.topping:
                    print(i)
    
    def masak(self):
        if self.pilihan == 1:
            self.step(self.stepMasakRebus)
        else:
            self.step(self.stepMasakGoreng)


"Procedural"

stepMasakRebus = ["Ambil bahan-bahan: ", "Rebus air", "Masukkan topping", "Masukkan mie", 
                  "Racik bumbu", "Tuang mie dan topping beserta air rebusan ke mangkok"]
stepMasakGoreng = ["Ambil bahan-bahan: ", "Rebus air", "Masukkan topping", "Masukkan mie", 
                   "Racik bumbu", "Tiriskan air", "Tuang mie dan topping ke mangkok"]
        
listTopping = []
pilihan = 0

def pilihanMie():
    global pilihan
    pilihan = int(input("Menu: "))

def pilihanTopping():
    global listTopping
    pilihan = input("Topping: ")
    listTopping = pilihan.split(", ")

def step(tipe=[]):
    for index, step in enumerate(tipe):
        print(step)
        if index == 0:
            for i in listTopping:
                print(i)

def masak(menu):
    if menu == 1:
        step(stepMasakRebus)
    else:
        step(stepMasakGoreng)