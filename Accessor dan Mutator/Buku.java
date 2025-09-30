
public class Buku {
    private String judul;
    private String penulis;
    private double harga;
    private int tahunTerbit;

    // Constructor
    public Buku(String judul, String penulis, double harga, int tahunTerbit) {
        this.judul = judul;
        this.penulis = penulis;
        // langsung gunakan setter untuk validasi
        setHarga(harga);
        setTahunTerbit(tahunTerbit);
    }

    // Accessor (Getter)
    public String getJudul() {
        return judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public double getHarga() {
        return harga;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    // Mutator (Setter)
    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public void setHarga(double harga) {
        if (harga > 0) {
            this.harga = harga;
        } else {
            System.out.println("Harga tidak valid. Harus lebih dari 0.");
        }
    } 

    public void setTahunTerbit(int tahunTerbit) {
        if (tahunTerbit > 2000) {
            this.tahunTerbit = tahunTerbit;
        } else {
            System.out.println("Tahun terbit tidak valid. Harus lebih dari tahun 2000.");
        }
    }
}

//Coba inheritance

class BukuTerjual extends Buku {
    private String pembeli;

    // Constructor inherit dari class Buku
    public BukuTerjual(Buku buku, String pembeli){
        super(buku.getJudul(), buku.getPenulis(), buku.getHarga(),buku.getTahunTerbit());
        this.pembeli = pembeli;
    }

    // Getter pembeli
    public String getPembeli(String nama){
        return pembeli;
    }

    // Setter pembeli
    public void setPembeli(String nama){
        System.out.printf("\nPerubahan pembeli: %s\n", nama);
        this.pembeli = nama;
    }

    // Method
    public void announce(){
        System.out.println("\n----Buku terjual----");
        System.out.printf("Judul buku   : %s\n", getJudul());
        System.out.printf("Pembeli      : %s\n", pembeli);
        System.out.printf("Harga        : %.2f\n", getHarga());
    }
}