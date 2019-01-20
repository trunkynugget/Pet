package trunky.pet;

public class Person {

    private String name;
    private Pet[] pets;
    private int numPets;
    private final int MAXPETS;
    private double money;

    public Person(String name, int maxPets, double money) {
        MAXPETS = maxPets;
        this.name = name;
        numPets = 0;
        pets = new Pet[MAXPETS];
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public boolean addPet(Pet p) {
        if (numPets < pets.length) {
            pets[numPets] = p;
            numPets++;
            return true;
        }

        return false;
    }

    public String petList() {
        String list = name + "'s pets: " + "\n";

        for (int i = 0; i < numPets; i++) {
            list += (i + 1) + ": " + pets[i].getName() + "\n";
        }

        return list;
    }

    public Pet getPet(int index) {
        return pets[index];
    }

    public int getNumPets() {
        return numPets;
    }

    public double getMoney() {
        return money;
    }

    public boolean spend(double cash) {
        if (cash < money) {
            money -= cash;
            return true;
        }
        return false;
    }

    public int getMaxPets() {
        return MAXPETS;
    }
}