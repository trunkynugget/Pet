package trunky.pet;

public class Pet {

    private String name;
    public static int year = 0;
    private int birthYear;

    private int atk;
    private int def;
    private int spd;

    public Pet(String name) {
        year++;
        this.name = name;
        birthYear = year;

        atk = (int) (Math.random() * 6) + 1;
        def = (int) (Math.random() * 6) + 1;
        spd = (int) (Math.random() * 6) + 1;
    }

    public Pet(String name, Pet parent1, Pet parent2) {
        year++;
        this.name = name;
        birthYear = year;

        int rng;
        rng = (int) (Math.random() * 2);

        if (rng == 0) {
            atk = parent1.atk;
        } else {
            atk = parent2.atk;
        }

        rng = (int) (Math.random() * 2);

        if (rng == 0) {
            def = parent1.def;
        } else {
            def = parent2.def;
        }

        rng = (int) (Math.random() * 2);

        if (rng == 0) {
            spd = parent1.spd;
        } else {
            spd = parent2.spd;
        }
    }

    public String getStats() {
        String stats = name + "'s Stats:" +
                "\nBirth Year: " + birthYear +
                "\nAge: " + getAge() +
                "\nAtk: " + atk +
                "\nDef: " + def +
                "\nSpd: " + spd;

        return stats;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public int getSpd() {
        return spd;
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public int getAge() {
        return (year - birthYear);
    }
}