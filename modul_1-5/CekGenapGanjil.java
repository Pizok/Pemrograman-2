public class CekGenapGanjil {
    public static void main(String[] args) {
        int angka = -9;

        if (angka < 0) {
            System.out.println(angka + " adalah bilangan negatif");
        } else if (angka == 0) {
            System.out.println(angka + " adalah bilangan nol");
        } else if (angka % 2 == 0) {
            System.out.println(angka + " adalah bilangan genap");
        } else {
            System.out.println(angka + " adalah bilangan ganjil");
        }
    }
}