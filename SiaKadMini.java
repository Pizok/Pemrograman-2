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
        // TODO: Tugas 30%, UTS 30%, UAS 40%
        double nilaiAkhir = (tgs*30/100) + (uts*30/100) + (uas*40/100);
        return nilaiAkhir;
    }

    static char konversiGrade(double akhir) {
        // TODO: A=85-100, B=75-84, C=60-74, D=45-59, E=<45
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
        return grade;
    }

    // ====== TAMPILAN TABEL ======
    static void tampilTabel(String[] nama, int[] tgs, int[] uts, int[] uas, double[] akhir, char[] grade, int n) {
        // TODO: cetak tabel rapi dengan loop
        int maxNama = 10; // minimal panjang
        for (int i = 0; i < n; i++) {
            if (nama[i].length() > maxNama) {
                maxNama = nama[i].length();
            }
        }
        maxNama += 2; // tambah padding

        // Cetak header
        System.out.printf("%-5s | %-" + maxNama + "s | %6s | %4s | %4s | %12s | %s\n", "Idx", "Nama", "Tugas", "UTS", "UAS", "Nilai Akhir", "Grade");
        System.out.println("=".repeat(maxNama + 50));

        // Cetak isi tabel
        for (int i = 0; i < n; i++) {
            System.out.printf("%-5d | %-" + maxNama + "s | %6d | %4d | %4d | %12.2f | %c\n", i+1, nama[i], tgs[i], uts[i], uas[i], akhir[i], grade[i]);
        }

        System.out.println("=".repeat(maxNama + 50));
        System.out.printf("Menampilkan %d data\n", n);
    }

    // ====== STATISTIK ======
    static double min(double[] arr, int n) {
        double minimal = 100;
        for (int i = 0; i < n; i++) {
            if (arr[i] < minimal) {
                minimal = arr[i];
            }
        }
        // TODO
        return minimal;
    }

    static double max(double[] arr, int n) {
        double maximal = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > maximal) {
                maximal = arr[i];
            }
        }
        // TODO
        return maximal;
    }

    static double rata2(double[] arr, int n) {
        double sumNilai = Arrays.stream(arr).sum();
        double jumlahNilai = n;
        double rata = sumNilai/jumlahNilai;
        // Todo
        return rata;
    }

    static int[] hitungDistribusiGrade(char[] grade, int n) {
        // TODO: loop isi d[0]..d[4]
        int[] d = new int[5]; // A,B,C,D,E
        for (int i = 0; i < n; i++) {
            if (grade[i] == 'A') {
                d[0] += 1;
            } else if (grade[i] == 'B') {
                d[1] += 1;
            } else if (grade[i] == 'C') {
                d[2] += 1;
            } else if (grade[i] == 'D') {
                d[3] += 1;
            } else {
                d[4] += 1;
            }
        }
        return d;
    }

    // ====== HISTOGRAM ======
    static void histogram(double[] akhir, int n) {
        // Rentang: A=85-100, B=75-84, C=60-74, D=45-59, E=<45
        // TODO: hitung dengan loop
        // Cetak bintang sesuai jumlah
        // for (int i=0; i<nb; i++) System.out.print("*");
        // lalu println per baris
        int[] d = new int[5]; // A, B, C, D, E
        for (int i = 0; i < n; i++) {
            if (akhir[i] < 45) {            //E
                d[4] += 1;
            } else if (akhir[i] <= 59) {    //D
                d[3] += 1;
            } else if (akhir[i] <= 74) {    //C
                d[2] += 1;
            } else if (akhir[i] <= 84) {    //B
                d[1] += 1;
            } else {                        //A
                d[0] += 1;
            }
        }

        System.out.println("Histogram Mahasiswa\n");
        
        for (int i = 0; i < 5; i++) {
            char grade = (char) ('A' + i);   // 'A' (65) + i → A, B, C, D, E
            System.out.print(grade + ": ");
    
            for (int j = 0; j < d[i]; j++) {
            System.out.print("*");
            }

            System.out.println();

        }
    }

    // ====== SORTING ======
    static void sortByAkhir(String[] nama, int[] tgs, int[] uts, int[] uas, double[] akhir, char[] grade, int n, boolean asc) {
        // Boleh bubble/selection, tapi SWAP semua kolom saat tukar posisi
        // TODO: nested loop sort
        // Bubble sort
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                boolean condition = asc ? (akhir[j] > akhir[j + 1]) : (akhir[j] < akhir[j + 1]);
                if (condition) {
                    swapDouble(akhir, j, j + 1);
                    swapChar(grade, j, j + 1);
                    swapInt(tgs, j, j + 1);
                    swapInt(uts, j, j + 1);
                    swapInt(uas, j, j + 1);
                    swapString(nama, j, j + 1);
                }
            }
        }

        tampilTabel(nama, tgs, uts, uas, akhir, grade, n); //Menampilkan data yang telah disort
    }

    //Method untuk Swap
    static void swapInt(int[] arr, int i, int j) {
        int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
    }
    static void swapDouble(double[] arr, int i, int j) {
        double temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
    }
    static void swapChar(char[] arr, int i, int j) {
        char temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
    }
    static void swapString(String[] arr, int i, int j) {
        String temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
    }

    // ====== SEARCH & EDIT ======
    static int[] searchNama(String[] nama, int n, String key) {
    //Menghitung dulu apakah ada nama yang match
    int matchCount = 0;
    for (int i = 0; i < n; i++) {
        if (nama[i].toLowerCase().contains(key)) {
            matchCount++;
        }
    }
    
    //Kalau tidak ada yang match, return array kosong
    if (matchCount == 0) {
        return new int[0];
    }
    
    //Kalau ada, baru membuat array yang berisi index nama
    int[] index = new int[matchCount];
    int arrayIndex = 0;
    for (int i = 0; i < n; i++) {
        if (nama[i].toLowerCase().contains(key)) {
            index[arrayIndex] = i;
            arrayIndex++;
        }
    }
    
    return index;
    }

    static void editNilai(Scanner in, int idx, int[] tgs, int[] uts, int[] uas, double[] akhir, char[] grade) {
        // TODO: minta input T/U/U, validasi 0-100, recalc akhir & grade
        int ubah = inputIntInRange(in, "Pilih nilai yang ingin diubah (1: Tugas, 2: UTS, 3: UAS): ", 1, 3);

        switch (ubah) {
            case 1:
                int tugas = inputIntInRange(in, "Nilai tugas baru: ", 0, 100);   //Input nilai baru
                tgs[idx] = tugas;                                                               //Assign
                akhir[idx] = hitungAkhir(tgs[idx], uts[idx], uas[idx]);                         //Kalkulasi lagi
                grade[idx] = konversiGrade(akhir[idx]);
                break;
            case 2:
                int utsBaru = inputIntInRange(in, "Nilai UTS baru: ", 0, 100);
                uts[idx] = utsBaru;
                akhir[idx] = hitungAkhir(tgs[idx], uts[idx], uas[idx]);
                grade[idx] = konversiGrade(akhir[idx]);
                break;
            case 3:
                int uasBaru = inputIntInRange(in, "Nilai UAS baru: ", 0, 100);
                uas[idx] = uasBaru;
                akhir[idx] = hitungAkhir(tgs[idx], uts[idx], uas[idx]);
                grade[idx] = konversiGrade(akhir[idx]);
                break;
        }
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
            System.out.println("\n\n==== MENU SIAKAD MINI ====");
            System.out.println("1. Tampilkan Tabel Nilai");
            System.out.println("2. Statistik (min, max, rata-rata, distribusi grade)");
            System.out.println("3. Histogram Nilai Akhir");
            System.out.println("4. Sorting by Nilai Akhir [1=ASC, 2=DESC]");
            System.out.println("5. Search Mahasiswa by Nama");
            System.out.println("6. Edit Nilai Mahasiswa");
            System.out.println("0. Exit");
            System.out.println("============================\n"); //tambahan pemisah
            int pilih = inputIntInRange(in, "Pilih: ", 0, 6);

            if (pilih == 0) break;

            switch (pilih) {
                case 1:
                    System.out.println("Output: "); //Tambah keterangan
                    tampilTabel(nama, tgs, uts, uas, akhir, grade, n);
                    break;
                case 2:
                    double mn = min(akhir, n);
                    double mx = max(akhir, n);
                    double rt = rata2(akhir, n);
                    int[] dist = hitungDistribusiGrade(grade, n);
                    System.out.println("Output: "); //Tambah keterangan
                    System.out.printf("Min: %.2f  Max: %.2f  Rata2: %.2f\n", mn, mx, rt);
                    System.out.println("A=" + dist[0] + " B=" + dist[1] + " C=" + dist[2] + " D=" + dist[3] + " E=" + dist[4]);
                    break;
                case 3:
                    System.out.println("Output: "); //Tambah keterangan
                    histogram(akhir, n);
                    break;
                case 4:
                    int mode = inputIntInRange(in, "Mode (1=ASC, 2=DESC): ", 1, 2);
                    System.out.println("\nOutput: "); //Tambah keterangan
                    System.out.println("Data telah di-sort.");
                    sortByAkhir(nama, tgs, uts, uas, akhir, grade, n, mode==1);
                    break;
                case 5:
                    System.out.print("Cari nama: ");
                    String key = in.nextLine().trim();
                    int[] idxMatch = searchNama(nama, n, key);
                    System.out.println("\nOutput: "); //Tambah keterangan
                    if (idxMatch.length > 0) {    //Ubah pencarian sehingga bisa menampilkan > 1 data
                        System.out.println("Ditemukan " + idxMatch.length + " hasil:");
                        // This is the for-each loop in action
                        for (int idx : idxMatch) {
                            System.out.printf("Ketemu: %s | Tgs:%d UTS:%d UAS:%d | Akhir:%.2f | Grade:%c\n",
                                nama[idx], tgs[idx], uts[idx], uas[idx], akhir[idx], grade[idx]);
                        }
                    } else {
                        System.out.println("Nama tidak ditemukan.");
                    }
                    break;
                case 6:
                    tampilTabel(nama, tgs, uts, uas, akhir, grade, n); //Menampilkan tabel
                    int idx2 = inputIntInRange(in, "Index mahasiswa (1-" + n + "): ", 1, n);
                    editNilai(in, idx2-1, tgs, uts, uas, akhir, grade);
                    System.out.println("\nOutput: "); //Tambah keterangan
                    System.out.println("Nilai diperbarui.");
                    tampilTabel(nama, tgs, uts, uas, akhir, grade, n); //Menampilkan tabel untuk melihat perubahan
                    break;
            }
        }

        System.out.println("Terima kasih. Program selesai.");
        in.close();
    }
}
