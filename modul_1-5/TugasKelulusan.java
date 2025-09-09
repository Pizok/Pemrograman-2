import java.util.Scanner;

public class TugasKelulusan {
    public static void main(String[] args) {
        //Input nilai.//
        try(Scanner input = new Scanner(System.in)){
            double nilaiTugas;
            double nilaiUjian;

            while (true) { 
                System.out.print("Masukkan nilai tugas (0-100): "); 
                nilaiTugas= input.nextDouble();

                System.out.print("Masukkan nilai ujian (0-100): ");
                nilaiUjian= input.nextDouble();

                if (nilaiTugas < 0 || nilaiTugas > 100 || nilaiUjian < 0 || nilaiUjian > 100) {
                    System.err.println("Terdapat kesalahan dalam input. Masukan nilai kembali!\n");
                } else {
                    break;
                }
            }
            
            //Menentukan nilai akhir.//
            double nilaiAkhir = (nilaiTugas*0.4) + (nilaiUjian*0.6);
            String predicate;

            if (nilaiAkhir < 70) {
                predicate = "D";
            } else if (nilaiAkhir > 70 && nilaiAkhir <= 80) {
                predicate = "C";
            } else if (nilaiAkhir > 80 && nilaiAkhir <= 90) {
                predicate = "B";
            } else {
                predicate = "A";
            }

            if (nilaiAkhir < 0 || nilaiAkhir > 100) {
                System.out.println("Nilai akhir tidak valid.");
            } else if (nilaiAkhir >= 60) {
                System.out.printf("Nilai %.2f, siswa dinyatakan LULUS dengan predikat \"%s\"", nilaiAkhir, predicate);
            } else {
                System.out.printf("Nilai %.2f, siswa dinyatakan TIDAK LULUS dengan predikat \"%s\"", nilaiAkhir, predicate);
            }
        }
    }
}