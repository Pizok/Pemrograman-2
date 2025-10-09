class Kendaraan {
    private String merk;
    private int kecepatan;

    public Kendaraan(String merk, int kecepatan) {
    this.merk = merk;
    setKecepatan(kecepatan);
    }

    public String getMerk() {
        return merk;
    }

    public int getKecepatan() {
        return kecepatan;
    }

    public void setMerk(String newMerk) {
        this.merk = newMerk;
    }

    public void setKecepatan(int newKecepatan) {
        if (newKecepatan < 1) {
            System.out.println("Input kecepatan salah, ulangi lagi!\n");
        } else {
            this.kecepatan = newKecepatan;
        }
    }


}

class Mobil extends Kendaraan{
    public Mobil(Kendaraan kendaraan) {
        super(kendaraan.getMerk(), kendaraan.getKecepatan());
    }
    
    public Mobil(Kendaraan kendaraan, int kecepatan) {
        super(kendaraan.getMerk(), kendaraan.getKecepatan());

        if (kecepatan != 0) {
           this.setKecepatan(kecepatan); 
        }
    }

    public void jalan() {
        System.out.printf("Motor %s berjalan dengan kecepatan %d km/jam\n", getMerk(), getKecepatan());
    }
}

class Motor extends Kendaraan{
    public Motor(Kendaraan kendaraan) {
        super(kendaraan.getMerk(), kendaraan.getKecepatan());
    }
    
    public Motor(Kendaraan kendaraan, int kecepatan) {
        super(kendaraan.getMerk(), kendaraan.getKecepatan());

        if (kecepatan != 0) {
           this.setKecepatan(kecepatan); 
        }
    }

    public void jalan() {
        System.out.printf("Motor %s berjalan dengan kecepatan %d km/jam\n", getMerk(), getKecepatan());
    }
}


public class KendaraanMain {
    public static void main(String[] args) {
        System.out.println("Kendaraan 1:");
        Kendaraan kendaraan1 = new Kendaraan("Toyota", 900);
        Mobil mobil1 = new Mobil(kendaraan1);
        //Tampilkan data
        System.out.println(kendaraan1.getMerk());
        System.out.println(kendaraan1.getKecepatan());
        mobil1.jalan();

        System.out.println("\nKendaraan 2:");
        Kendaraan kendaraan2 = new Kendaraan("Ducati", 100);
        Motor motor1 = new Motor(kendaraan2, 200); //Override
        //Tampilkan data
        System.out.println(kendaraan2.getMerk());
        System.out.println(kendaraan2.getKecepatan());
        motor1.jalan();

        System.out.println("\nKendaraan 3:");
        Kendaraan kendaraan3 = new Kendaraan("Kawasaki", 0); //Coba kecepatan 0 km/jam
        kendaraan3.setKecepatan(120);
        Motor motor2 = new Motor(kendaraan3);
        //Tampilkan data
        System.out.println(kendaraan3.getMerk());
        System.out.println(kendaraan3.getKecepatan());
        motor2.jalan();
    }
}

