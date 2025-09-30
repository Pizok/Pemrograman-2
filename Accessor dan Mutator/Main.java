public class Main {
    public static void main(String[] args) {
        // Membuat objek Mahasiswa
        Mahasiswa mhs1 = new Mahasiswa("Ilham Rifai", "123456", 3.8);

        // Mengakses data dengan Accessor
        System.out.println("Nama: " + mhs1.getNama());
        System.out.println("NIM: " + mhs1.getNim());
        System.out.println("IPK: " + mhs1.getIpk());

        // Mengubah data dengan Mutator
        mhs1.setNama("Takwim Ahsani");
        mhs1.setIpk(3.9);

        System.out.println("\nSetelah diubah:");
        System.out.println("Nama: " + mhs1.getNama());
        System.out.println("IPK: " + mhs1.getIpk());

        // Coba set nilai tidak valid
        mhs1.setIpk(5.5);
    }
}
