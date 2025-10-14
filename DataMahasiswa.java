import java.time.LocalDate;
import java.util.Scanner;

class Mahasiswa {
    private String nama;
    private int age;

    // Construcktor Object
    public Mahasiswa(String namaMahasiswa, int umur){
        this.nama = namaMahasiswa;
        setUmur(umur);
    }
    
    // Getter atribut nama
    public String getNama(){
        return nama;
    }

    // Getter atribut umur (age)
    public int getUmur(){
        return age;
    }

    // Setter atribut nama
    public void setNama(String namaMahasiswa){
        this.nama = namaMahasiswa;
    }

    // Setter atribut umur (age)
    public void setUmur(int umur){
        this.age = umur;
    }

    // Method untuk menentukan kategori mahasiswa
    public String kategoriUmur(){
        if (this.age >= 18) { 
            return "Mahasiswa Dewasa";
        } else {
            return "Mahasiswa di bawah umur";
        }
    }

    // Method untuk menghitung tahun lahir mahasiswa
    public int tahunLahir(){
        int tahun = LocalDate.now().getYear();
        int lahir = tahun - this.age;
        return lahir;
    }

    // Method untuk menampilkan data
    public void tampilkanData(){
        System.out.println("Nama: " + this.nama);
        System.out.println("Umur: " + this.age);
        System.out.println("Kategori: " + kategoriUmur());
        System.out.println("Tahun lahir: " + tahunLahir());
    }
}


public class DataMahasiswa {
    // Method untuk input yang tervalidasi
    public static int input(Scanner scan, String perintah, int min, int max) {
        int value = 0;  
        boolean valid = false;

        while (valid == false) {
            try {
                System.out.print(perintah);
                value = scan.nextInt(); 

                if (value >= min && value <= max) {
                    valid = true; 
                } else {
                    System.out.println("Input harus diantara " + min + " dan " + max + "!");
                }
            } catch (Exception e) {
                System.out.println("Input harus merupakan angka!");
            }
            scan.nextLine();
        }
        return value;
    }

    // Main method
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("--- Selamat Datang di Sistem Pendataan Mahasiswa ---");

        // Isi data mahasiswa
        int jumlah = input(scan, "Jumlah mahasiswa: ", 1, 100);

        Mahasiswa[] mahasiswa = new Mahasiswa[jumlah];

        for (int i = 0; i < (jumlah); i++) {
            System.out.println("\nMahasiswa ke-"+ (i+1));

            System.out.print("Nama: ");
            String nama = scan.nextLine();
            
            int umur = input(scan, "Umur: ", 1, 150);

            mahasiswa[i] = new Mahasiswa(nama, umur);
        }
        
        // Menampilkan data mahasiswa yang sudah di-input
        System.out.println("\nData Mahasiswa");
        System.out.println("---------------------------------");

        for (int i = 0; i < mahasiswa.length; i++) {
            System.out.println("\nMahasiswa ke-"+ (i+1));
            mahasiswa[i].tampilkanData();
        }

        scan.close();
    }   
}
