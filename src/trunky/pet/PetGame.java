package trunky.pet;

import java.util.Scanner;

public class PetGame {
    private static PetGame game = new PetGame();
    private final String INVALID = "Invalid input.";

    private boolean quit;
    private Scanner sc;
    private Person player;
    private String input;

    private PetGame() {
        sc = new Scanner(System.in);
        quit = false;
    }

    public static PetGame getGame() {
        return game;
    }

    public void run() {
        intro();
        while (!quit) {
            status();
            input = sc.nextLine();
            System.out.println();
            handleInput(input);
        }
        sc.close();
    }

    private void intro() {
        System.out.println("What is your name?");
        input = sc.nextLine();

        player = new Person(input, 12, 1000);

        System.out.println("\nYou got a pet! What is its name?");
        input = sc.nextLine();

        player.addPet(input);
    }

    private void status() {
        System.out.println("\nYear: " + Pet.year + "\nPets: " + player.getNumPets() + "\nMoney: $" + player.getMoney());
        System.out.println("\nWhat would you like to do?");
        System.out.println("(p): Check Pets");
        System.out.println("(b): Buy Pet");
        System.out.println("(s): Sell Pet");
        System.out.println("(c): Create Pet");
        System.out.println("(q): Quit");
    }

    private void handleInput(String choice) {
        switch(choice) {
            case "p":
                checkPet();
                break;
            case "q":
                quit = true;
                break;
            case "b":
                buyPet();
                break;
            case "s":
                sellPet();
                break;
            case "c":
                createPet();
                break;
            default:
                System.out.println(INVALID);
        }
    }

    private void checkPet() {
        System.out.println(player.petList());
        System.out.println("Which pet?");
        input = sc.nextLine();

        try {
            int inputNum = Integer.parseInt(input);
            if (inputNum <= player.getNumPets() && inputNum > 0) {
                System.out.println("\n" + player.getPet(inputNum - 1).getStats());
            } else {
                System.out.println("\n" + INVALID);
            }
        } catch (NumberFormatException e) {
            System.out.println("\n" + INVALID);
        }
    }

    private void buyPet() {
        System.out.println("A new egg costs $300. Purchase?" +
                "\n(y): Yes" +
                "\n(n): No");
        input = sc.nextLine();

        if (input.equals("y") && (player.spend(300))) {
            System.out.println("\nYou got a pet! What is its name?");
            input = sc.nextLine();

            player.addPet(input);

            System.out.println("A new pet is born, and with it, a new year.");
        } else if (input.equals("y") && !player.spend(300)) {
            System.out.println("\nYou don't got the cash!");

        } else if (!input.equals("n")) {
            System.out.println("\n" + INVALID);
        }
    }

    private void sellPet() {

    }

    private void createPet() {
        System.out.println(player.petList());
        System.out.println("Select 2 different pets for the creation process.");
        int index1;
        int index2;
        try {
            index1 = sc.nextInt();
            index2 = sc.nextInt();

            if (index1 != index2 && index1 <= player.getNumPets() && index2 <= player.getNumPets()) {

                System.out.println("\nYou got a pet! What is its name?");
                sc.nextLine();
                input = sc.nextLine();

                player.addPet(input, player.getPet(index1 - 1), player.getPet(index2 - 1));

                System.out.println("\nA new pet is born, and with it, a new year.");

            } else {
                System.out.println("\nError. Pet could not be created.");
            }

        } catch (NumberFormatException e) {
            System.out.println("\n" + INVALID);
        }
    }
}
