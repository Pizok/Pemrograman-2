import java.util.Scanner;

public class Branching {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Double nilai;
        Character grade;

        try(scan) {
            System.out.println("Masukkan nilai: ");
            nilai = scan.nextDouble();
        }

        if (nilai < 40) {
            grade = 'E';
        } else if (nilai >= 40 && nilai <= 54) {
            grade = 'D';
        } else if (nilai >= 55 && nilai <= 69) {
            grade = 'C';
        } else if (nilai >= 70 && nilai <= 84) {
            grade = 'B';
        } else {
            grade = 'A';
        }
        
        System.out.printf("Grade dari nilai %.2f adalah %c\n", nilai, grade);
    }
    
    

    
}
