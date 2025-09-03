import java.util.Scanner;

public class CekPositifNegatif {
    public static void main(String[] args) {
        try(Scanner input = new Scanner(System.in)) {
            System.out.print("Masukkan angka: ");
            double angka = input.nextDouble();

            if (angka > 0) {
                System.out.println("Angka positif");
            } else if (angka < 0) {
                System.out.println("Angka negatif");
            } else {
                System.out.println("Angka nol");
            }
        } 
    }   
} //Mencoba pakai try//
