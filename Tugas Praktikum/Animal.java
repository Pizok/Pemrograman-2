class AnimalIdentity {
    String name;
    String species;
    int age;

    public AnimalIdentity(String AnimalName, String AnimalSpecies, int AnimalAge) {
    this.name = AnimalName;
    this.species = AnimalSpecies;
    this.age = AnimalAge;
    }

    public AnimalIdentity(String Aname, String Aspecies) {
    this.name = Aname;
    this.species = Aspecies;
    this.age = -1;
    }

    public void identity(){
        if (age < 0) {
            System.out.printf("%s seekor %s\n", name, species);
        } else {
            System.out.printf("%s seekor %s berumur %d tahun\n", name, species, age);
        }
        
    }

    public void makeSound(String sound){
        System.out.printf("%s seekor %s %s\n", name, species, sound);
    }

    public void move(String move){
        System.out.printf("%s seekor %s %s\n", name, species, move);
    }
}

public class Animal {
    public static void main(String[] args) {
        AnimalIdentity animal1 = new AnimalIdentity("Oreo", "Kucing", 3);
        animal1.identity();
        animal1.makeSound("mengeong");
        animal1.move("berjalan");

        AnimalIdentity animal2 = new AnimalIdentity("Janki", "Beo");
        animal2.identity();
        animal2.makeSound("Berkicau");
        animal2.move("Terbang");
    }
    
}