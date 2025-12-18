class Airport:
    def __init__(self, nama):
        self.nama = nama
        self.airlines = []

    def addAirline(self, airline):
        for i in airline:
            self.airlines.append(i)

    def showAirline(self):
        print(f"\nDaftar Maskapai dan Penerbangan Bandara {self.nama}:\n")
        for i in self.airlines:
            print(f"Maskapai {i.showName()}:")
            i.showFlight()

class Airline:
    def __init__(self, nama):
        self.nama = nama
        self.flight = []

    def addFlight(self, kode):
        for i in kode:
            self.flight.append(i)

    def showName(self):
        return self.nama
    
    def showFlight(self):
        if len(self.flight) < 1:
                print("Belum ada penerbangan")
        for i in self.flight:       
            print(f"{i.kode}: {i.keberangkatan} -> {i.tujuan}; penumpang:")
            i.showPassanger()

class Flight:
    def __init__(self, kode, keberangkatan, tujuan):
        self.kode = kode
        self.keberangkatan = keberangkatan
        self.tujuan = tujuan
        self.passanger = []

    def addPassanger(self, penumpang):
        for i in penumpang:
            self.passanger.append(i)

    def showPassanger(self):
        if len(self.passanger) < 1:
                print("Belum ada Penumpang")
        for i, penumpang in enumerate(self.passanger):       
            print(f"{i+1}. {penumpang.nama}")
            
class Passanger:
    def __init__(self, nama):
        self.nama = nama

#Percobaan

a1 = Airport("Soekarno Hatta")

airline1 = Airline("Garuda Indonesia")
airline2 = Airline("Lion Air")
a1.addAirline([airline1, airline2])

flightga1 = Flight("GA111", "Jakarta", "Surabaya")
flightga2 = Flight("GA121", "Jakarta", "Bandung")
airline1.addFlight([flightga1, flightga2])

pa1 = Passanger("Budi")
pa2 = Passanger("Mia")
pa3 = Passanger("Nia")
pa4 = Passanger("Bambang")
flightga1.addPassanger([pa1, pa2, pa3, pa4])

a1.showAirline()



    



