"""
Kode untuk: 3. warung indomie with same cooking steps but different ingredients for different location in different city

keterangan:
Menu yang ada = Mie rebus, Mie goreng, Mie goreng jumbo {kode: 1, 2, 3}
Topping = Sayur, Telur, Bakso, Sosis, Ayam, Cabe rawit
Spesial Ingredients = {jakarta: ayam taichan, bandung: cilok, surabaya: cabe rawit giling} (kode: 10, 20, 30)
"""

"OOP"
class warung:
    def __init__(self, kota, pilihanMie, pilihanTopping=[]):
        self.lokasi = kota
        self.pilihan = pilihanMie
        self.topping = pilihanTopping
        self.spesialIngredients = {1: "ayam taichan", 2: "cilok", 3: "cabe rawit giling"}
        self.stepMasakRebus = ["Ambil bahan-bahan: ", "Rebus air", "Masukkan topping", "Masukkan mie", 
                               "Racik bumbu", "Tuang mie dan topping beserta air rebusan ke mangkok"]
        self.stepMasakGoreng = ["Ambil bahan-bahan: ", "Rebus air", "Masukkan topping", "Masukkan mie", 
                                "Racik bumbu", "Tiriskan air", "Tuang mie dan topping ke mangkok"]
      
    def step(self, kodeKota, tipe=[]):
        for index, step in enumerate(tipe):
            print(step)
            if index == 0:
                print("indomie")
                "Tambahan baris kode untuk nambah ingredient"
                print(self.spesialIngredients.get(kodeKota)) 
                for i in self.topping:
                    print(i)
    
    def masak(self):
        if self.pilihan == 1:
            self.step(self.lokasi ,self.stepMasakRebus)
        else:
            self.step(self.lokasi, self.stepMasakGoreng)


"Procedural"

spesialIngredients = {1: "ayam taichan", 2: "cilok", 3: "cabe rawit giling"}
stepMasakRebus = ["Ambil bahan-bahan: ", "Rebus air", "Masukkan topping", "Masukkan mie", 
                  "Racik bumbu", "Tuang mie dan topping beserta air rebusan ke mangkok"]
stepMasakGoreng = ["Ambil bahan-bahan: ", "Rebus air", "Masukkan topping", "Masukkan mie", 
                   "Racik bumbu", "Tiriskan air", "Tuang mie dan topping ke mangkok"]
        
listTopping = []
pilihan = 0
kodeKota = 0

def lokasi():
    global kodeKota
    kodeKota = int(input("Menu: "))

def pilihanMie():
    global pilihan
    pilihan = int(input("Menu: "))

def pilihanTopping():
    global listTopping
    pilihan = input("Topping: ")
    listTopping = pilihan.split(", ")

def step(kodeKota, tipe=[]):
    for index, step in enumerate(tipe):
        print(step)
        if index == 0:
            print("indomie")
            print(spesialIngredients.get(kodeKota))
            for i in listTopping:
                print(i)

def masak(menu):
    if menu == 1:
        step(kodeKota, stepMasakRebus)
    else:
        step(kodeKota, stepMasakGoreng)