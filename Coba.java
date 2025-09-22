class Orang {
        String nama;
        int umur;

    public Orang (String nama1, int umur1) {
        this.nama = nama1;
        this.umur = umur1;
    }
    
    public void sapa() {
        System.out.println("Haloo " + nama + ", kamu umur " + umur);
    }
}

class Mahasiswa extends Orang {
    public Mahasiswa(Orang O) {
        super(O.nama, O.umur);
    }
    
    public void identitas(Orang O) {
        System.out.println("nama mahasiswa: " + O.nama);
        System.out.println("umur mahasiswa: " + O.umur);
        System.out.println("Status mahasiswa: aktif" );
    }
    
}

public class Coba {
    public static void main(String[] args) {
        Orang person1 = new Orang("Nama", 19);
        person1.sapa();

        Orang person2 = new Orang("Lalalala", 200);
        person2.sapa();
        person2.nama = "Ilham";
        person2.sapa();

        Mahasiswa m1 = new Mahasiswa(person2);
        m1.identitas(person2);
        
    }
}
