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

            if (nilaiAkhir < 0 || nilaiAkhir > 100) {
                System.out.println("Nilai akhir tidak valid.");
            } else if (nilaiAkhir >= 60) {
                System.out.printf("Nilai %.2f, siswa dinyatakan LULUS", nilaiAkhir);
            } else {
                System.out.printf("Nilai %.2f, siswa dinyatakan TIDAK LULUS", nilaiAkhir);
            }
        }
    }
}