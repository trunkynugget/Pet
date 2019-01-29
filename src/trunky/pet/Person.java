package trunky.pet;
import java.util.*;

public class Person {

    private String name;
    private List<Pet> pets;
    private int money;

    public Person(String name, int maxPets, int money) {
        this.name = name;
        pets = new ArrayList<>();
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public boolean addPet(Pet p) {
        pets.add(p);
        return true;
    }
    
    public boolean addPet(String name) {
        pets.add(new Pet(name));
        return true;
    }
    
    public boolean addPet(String name, Pet parent1, Pet parent2) {
        pets.add(new Pet(name, parent1, parent2));
        return true;
    }

    public String petList() {
        String list = name + "'s pets: " + "\n";

        for (int i = 0; i < getNumPets(); i++) {
            list += (i + 1) + ": " + pets.get(i).getName() + "\n";
        }

        return list;
    }

    public Pet getPet(int index) {
        return pets.get(index);
    }

    public int getMoney() {
        return money;
    }
    
    public int getNumPets() {
    	return pets.size();
    }

    public boolean spend(int amount) {
        if (amount < money) {
            money -= amount;
            return true;
        }
        return false;
    }
    
    public void addMoney(int amount) {
    	money += amount;
    }
    
}