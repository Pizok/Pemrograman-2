import java.util.Scanner;

public class Looping {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n;
        try(scan) {
            System.out.print("Input angka: ");   
            n = scan.nextInt();
        }   
        
        System.out.println("\nOutput: "); 
        int sum = 0;
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < (i+1); j++) {
                System.out.print(j);
            }
            sum += i;
            System.out.print("\n");
        }

        System.out.println("Hasil penjumlahan angka:" + sum);
        
        
    }
}
