import java.time.LocalDate;
import java.util.Scanner;

class Mahasiswa {
    private String nama;
    private int age;

    public Mahasiswa(String namaMahasiswa, int umur){
        this.nama = namaMahasiswa;
        this.age = umur;
    }
    
    public String getNama(){
        return nama;
    }

    public int getUmur(){
        return age;
    }

    public void setNama(String namaMahasiswa){
        this.nama = namaMahasiswa;
    }

    public void setUmur(int umur){
            this.age = umur;
    }

    public String kategoriUmur(){
        String hasil;
        if (this.age >= 18) { 
            hasil = "Mahasiswa Dewasa";
        } else {
            hasil = "Mahasiswa di bawah umur";
        }
        return hasil;
    }

    public int tahunLahir(){
        int tahun = LocalDate.now().getYear();
        int lahir = tahun - this.age;
        return lahir;
    }

    public void tampilkanData(){
        System.out.println("Nama: " + this.nama);
        System.out.println("Umur: " + this.age);
        System.out.println("Kategori: " + kategoriUmur());
        System.out.println("Tahun lahir: " + tahunLahir());
    }
}


public class DataMahasiswa {
    public static int input(Scanner scan, String perintah, int min, int max) {
        int value = 0;  
        boolean valid = false;

        while (valid == false) {
            System.out.print(perintah);
            value = scan.nextInt(); 

            if (value >= min && value <= max) {
                valid = true; 
            } else {
                System.out.println("Input harus diantara" + min + " dan " + max + "!");
            }
        }

        return value;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("--- Selamat Datang di Sistem Pendataan Mahasiswa ---");

        // Isi data mahasiswa
        int jumlah = input(scan, "Jumlah mahasiswa: ", 1, 100);
        scan.nextLine();

        Mahasiswa[] mahasiswa = new Mahasiswa[jumlah];

        for (int i = 0; i < (jumlah); i++) {
            System.out.println("\nMahasiswa ke-"+ (i+1));

            System.out.print("Nama: ");
            String nama = scan.nextLine();
            
            int umur = input(scan, "Umur: ", 1, 150);
            scan.nextLine();

            mahasiswa[i] = new Mahasiswa(nama, umur);
        }
        
        System.out.println("\n--Data Mahasiswa--");

        for (int i = 0; i < mahasiswa.length; i++) {
            System.out.println("\nMahasiswa ke-"+ (i+1));
            mahasiswa[i].tampilkanData();
        }

        scan.close();
    }   
}
