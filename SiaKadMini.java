import java.util.*;

public class SiaKadMini {

    // ====== UTIL INPUT ======
    static int inputIntInRange(Scanner in, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            if (in.hasNextInt()) {
                int val = in.nextInt();
                in.nextLine(); // bersihkan newline
                if (val >= min && val <= max) return val;
            } else {
                in.nextLine(); // buang input non-angka
            }
            System.out.println("Input harus antara " + min + " - " + max + ". Coba lagi..");
        }
    }

    // ====== PERHITUNGAN NILAI ======
    static double hitungAkhir(double tgs, double uts, double uas) {
        double nilaiAkhir = (tgs*30/100) + (uts*30/100) + (uas*40/100);
        // TODO: Tugas 30%, UTS 30%, UAS 40%
        return nilaiAkhir; // ganti
    }

    static char konversiGrade(double akhir) {
        char grade;
        if (akhir < 45) {
            grade = 'E';
        } else if (akhir >= 45 && akhir <= 59) {
            grade = 'D';
        } else if (akhir >= 60 && akhir <= 74) {
            grade = 'C';
        } else if (akhir >= 75 && akhir <= 84) {
            grade = 'B';
        } else {
            grade = 'A';
        }
        // TODO: A=85-100, B=75-84, C=60-74, D=45-59, E=<45
        return grade; // ganti
    }

    // ====== TAMPILAN TABEL ======
    static void tampilTabel(String[] nama, int[] tgs, int[] uts, int[] uas, double[] akhir, char[] grade, int n) {
        // TODO: cetak tabel rapi dengan loop
    }

    // ====== STATISTIK ======
    static double min(double[] arr, int n) {
        Arrays.sort(arr);
        double minimal = arr[0]; 
        // TODO
        return minimal;
    }

    static double max(double[] arr, int n) {
        Arrays.sort(arr);
        double maxNilai = arr[arr.length-1];
        // TODO
        return maxNilai;
    }

    static double rata2(double[] arr, int n) {
        // TODO
        return 0.0;
    }

    static int[] hitungDistribusiGrade(char[] grade, int n) {
        int[] d = new int[5]; // A,B,C,D,E
        // TODO: loop isi d[0]..d[4]
        return d;
    }

    // ====== HISTOGRAM ======
    static void histogram(double[] akhir, int n) {
        // Rentang: A=85-100, B=75-84, C=60-74, D=45-59, E=<45
        // TODO: hitung dengan loop
        // Cetak bintang sesuai jumlah
        // for (int i=0; i<nb; i++) System.out.print("*");
        // lalu println per baris
    }

    // ====== SORTING ======
    static void sortByAkhir(String[] nama, int[] tgs, int[] uts, int[] uas, double[] akhir, char[] grade, int n, boolean asc) {
        // Boleh bubble/selection, tapi SWAP semua kolom saat tukar posisi
        // TODO: nested loop sort
    }

    // ====== SEARCH & EDIT ======
    static int searchNama(String[] nama, int n, String key) {
        // Case-insensitive
        // TODO: loop linear search
        return -1;
    }

    static void editNilai(Scanner in, int idx, int[] tgs, int[] uts, int[] uas, double[] akhir, char[] grade) {
        // TODO: minta input T/U/U, validasi 0-100, recalc akhir & grade
    }

    // ====== MAIN ======
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = inputIntInRange(in, "Masukkan jumlah mahasiswa (1-50): ", 1, 50);

        String[] nama = new String[n];
        int[] tgs = new int[n];
        int[] uts = new int[n];
        int[] uas = new int[n];
        double[] akhir = new double[n];
        char[] grade = new char[n];

        // Input data awal (validasi nilai)
        for (int i = 0; i < n; i++) {
            System.out.println("\nMahasiswa ke-" + (i+1));
            System.out.print("Nama : ");
            nama[i] = in.nextLine();

            tgs[i] = inputIntInRange(in, "Nilai Tugas (0-100): ", 0, 100);
            uts[i] = inputIntInRange(in, "Nilai UTS (0-100): ", 0, 100);
            uas[i] = inputIntInRange(in, "Nilai UAS (0-100): ", 0, 100);

            akhir[i] = hitungAkhir(tgs[i], uts[i], uas[i]);
            grade[i] = konversiGrade(akhir[i]);
        }

        // Loop menu
        while (true) {
            System.out.println("\n==== MENU SIAKAD MINI ====");
            System.out.println("1. Tampilkan Tabel Nilai");
            System.out.println("2. Statistik (min, max, rata-rata, distribusi grade)");
            System.out.println("3. Histogram Nilai Akhir");
            System.out.println("4. Sorting by Nilai Akhir [ASC, 2=DESC]");
            System.out.println("5. Search Mahasiswa by Nama");
            System.out.println("6. Edit Nilai Mahasiswa");
            System.out.println("0. Exit");
            int pilih = inputIntInRange(in, "Pilih: ", 0, 6);

            if (pilih == 0) break;

            switch (pilih) {
                case 1:
                    tampilTabel(nama, tgs, uts, uas, akhir, grade, n);
                    break;
                case 2:
                    double mn = min(akhir, n);
                    double mx = max(akhir, n);
                    double rt = rata2(akhir, n);
                    int[] dist = hitungDistribusiGrade(grade, n);
                    System.out.printf("Min: %.2f  Max: %.2f  Rata2: %.2f\n", mn, mx, rt);
                    System.out.println("A=" + dist[0] + " B=" + dist[1] + " C=" + dist[2] + " D=" + dist[3] + " E=" + dist[4]);
                    break;
                case 3:
                    histogram(akhir, n);
                    break;
                case 4:
                    int mode = inputIntInRange(in, "Mode (1=ASC, 2=DESC): ", 1, 2);
                    sortByAkhir(nama, tgs, uts, uas, akhir, grade, n, mode==1);
                    System.out.println("Data telah di-sort.");
                    break;
                case 5:
                    System.out.print("Cari nama: ");
                    String key = in.nextLine();
                    int idx = searchNama(nama, n, key);
                    if (idx >= 0) {
                        System.out.printf("Ketemu: %s | Tgs:%d UTS:%d UAS:%d | Akhir:%.2f | Grade:%c\n",
                                nama[idx], tgs[idx], uts[idx], uas[idx], akhir[idx], grade[idx]);
                    } else {
                        System.out.println("Tidak ditemukan.");
                    }
                    break;
                case 6:
                    int idx2 = inputIntInRange(in, "Index mahasiswa (1-" + n + "): ", 1, n);
                    editNilai(in, idx2-1, tgs, uts, uas, akhir, grade);
                    System.out.println("Nilai diperbarui.");
                    break;
            }
        }

        System.out.println("Terima kasih. Program selesai.");
        in.close();
    }
}
