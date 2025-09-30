public class BukuMain {
    public static void main(String[] args) {
    // Membuat objek Buku 1
    Buku buku1 = new Buku("Dasar Pemrograman Bagi Pemula", "Ahsani Takwim", 75000, 2020);

    // Menampilkan data
    System.out.println("\n---Buku 1");
    System.out.println("Judul : " + buku1.getJudul());
    System.out.println("Penulis : " + buku1.getPenulis());
    System.out.println("Harga : " + buku1.getHarga());

    // Mengubah data dengan Setter
    buku1.setHarga(-10000); // contoh input tidak valid
    buku1.setHarga(85000); // input valid

    // Menampilkan data setelah diubah
    System.out.println("\nSetelah diubah:");
    System.out.println("Judul : " + buku1.getJudul());
    System.out.println("Penulis : " + buku1.getPenulis());
    System.out.println("Harga : " + buku1.getHarga());

    // Membuat objek Buku 2
    Buku buku2 = new Buku("Dasar Pemrograman Java", "Ahsani Takwim", 80000, 2021);

    // Menampilkan data
    System.out.println("\n---Buku 2");
    System.out.println("Judul : " + buku2.getJudul());
    System.out.println("Penulis : " + buku2.getPenulis());
    System.out.println("Harga : " + buku2.getHarga());

    // Coba Inheritance
    BukuTerjual bt1 = new BukuTerjual(buku1, "Ilham");
    bt1.announce();

    // Ubah nama
    bt1.setPembeli("Budi");
    bt1.announce();
    }
}

    // // Membuat objek Buku 1
    // Buku buku1 = new Buku("Pemrograman OOP Java", "Ahsani Takwim", 90000, 2022);

    // // Menampilkan data awal
    // System.out.println("Judul : " + buku1.getJudul());
    // System.out.println("Penulis : " + buku1.getPenulis());
    // System.out.println("Harga : " + buku1.getHarga());

    // // Mengubah data dengan Setter
    // buku1.setJudul("Belajar Java dengan Mudah");
    // buku1.setHarga(-5000); // contoh input tidak valid
    // buku1.setHarga(85000); // input valid

    // // Menampilkan data setelah diubah
    // System.out.println("\nSetelah diubah:");
    // System.out.println("Judul : " + buku1.getJudul());
    // System.out.println("Penulis : " + buku1.getPenulis());
    // System.out.println("Harga : " + buku1.getHarga());
