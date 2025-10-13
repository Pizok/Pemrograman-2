import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class EnkripsiPesan {
    static int nEncrypt = 1; //
    static int nDecrypt = 1; //

    // Fungsi untuk enkripsi pesan dari user
    public static void Enkripsi(String pesan) {
        StringBuilder text = new StringBuilder(); // StringBuilder untuk membuat string dari Unicode; sebagai array berisi unicode

        // Looping pesan agar diubah menjadi unicode lalu ditambahkan 10, unicode-nya, sebagai pola enkripsi
        for (int i = 0; i < pesan.length(); i++) {
            int code = pesan.codePointAt(i); // Ubah ke Unicode
            text.appendCodePoint(code + 10); // Enkripsi
        }

        System.out.println("Membuat file...");
        nEncrypt++; // Increment untuk jumlah pesan enkripsi yang dibuat
        simpanKeFile("Enkripsi", text.toString(), nEncrypt); // Jalankan fungsi simpanKeFile untuk ubah jadi .txt
    }
    
    // Fungsi untuk enkripsi pesan dari user; secara struktur sama
    public static void DekripsiPesan(String pesan) {
        StringBuilder text = new StringBuilder();

        for (int i = 0; i < pesan.length(); i++) {
            int code = pesan.codePointAt(i);
            text.appendCodePoint(code - 10); // Karena dekripsi, maka unicode dari setiap char di pesan dikurangi 10
        }

        System.out.println("Membuat file...");
        nDecrypt++; // Increment untuk jumlah pesan dekripsi yang dibuat
        simpanKeFile("Dekripsi", text.toString(), nDecrypt);
    }

    // Fungsi untuk membuat file .txt
    public static void simpanKeFile(String jenis, String isi, int n) { // mengambil argumen enkripsi/dekripsi, pesan, dan jumlah yang sudah dibuat
        //Inisiasi waktu lokal dan nama file
        LocalDateTime localDate = LocalDateTime.now(); // get waktu lokal
        DateTimeFormatter dateTemplate = DateTimeFormatter.ofPattern("_ddMMyyyy_HHmmss"); // membuat template stamp waktu untuk nama file
        String namaFile = jenis+"Message_"+ n + localDate.format(dateTemplate) + ".txt"; // variabel untuk nama file yang akan dibuat

        //Membuat file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(namaFile))) { // try with resource untuk bufferedwriter
            writer.write(isi); // Menulis isi di dalam .txt
            writer.write("\n\n" + jenis + " pada "+ localDate); // Menambahkan date untuk setiap .txt yang dibuat
            System.out.println("Pesan berhasil disimpan ke file: " + namaFile); // Message jika file berhasil disimpan
        } catch (IOException e) { // Catch sebagai "if" jika ada error yang terjadi dalam membuat file
            System.out.println("Terjadi kesalahan saat menyimpan file: " + e.getMessage());// Message jika file gagal disimpan
        }
    }

    //Main Function
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // Membuat object untuk scanner input user

        // Looping while untuk program
        while (true) {   
            System.out.println("\n---Selamat datang di sistem enkripsi pesan---");
            System.out.println("Menu:");
            System.out.println("1. Enkripsi pesan");
            System.out.println("2. Dekripsi Pesan");
            System.out.println("0. Keluar sistem");
            System.out.print("Pilihan: ");
            int pilihan = scan.nextInt(); // Scanner input user
            scan.nextLine(); // Menghapus enter agar tidak error
            
            // Switch sesuai input user
            switch (pilihan) {  
                case 1: // Enkripsi pesan
                    System.out.println("\nMasukkan pesan yang ingin di-Enkripsi"); // Print message
                    String pesan = scan.nextLine(); // Mengambil input pesan dari user
                    Enkripsi(pesan); // jalankan fungsi enkripsi
                    break; // Looping kembali

                case 2: // Dekripsi pesan
                    System.out.println("\nMasukkan pesan yang ingin di-Dekripsi"); // Print message
                    String pesanDekrip = scan.nextLine(); // Mengambil input pesan dari user
                    DekripsiPesan(pesanDekrip); // jalankan fungsi dekripsi
                    break; // Looping kembali
            
                case 0: // Keluar program
                    System.out.println("Keluar dari sistem...");
                    scan.close(); // Menutup akses scanner
                    return; // Menghentikan looping
            }
        }
    }
}
