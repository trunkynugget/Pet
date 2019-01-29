package trunky.pet;

import java.util.Scanner;

public class PetDriver {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;

        System.out.println("What is your name?");
        input = sc.nextLine();

        Person player = new Person(input, 12, 1000);

        System.out.println("\nYou got a pet! What is its name?");
        input = sc.nextLine();

        player.addPet(input);

        boolean quit = false;

        while (!quit) {
            System.out.println("\nYear: " + Pet.year + "\nPets: " + player.getNumPets() + "\nMoney: $" + player.getMoney());
            System.out.println("\nWhat would you like to do?");
            System.out.println("(p): Check Pets");
            System.out.println("(b): Buy Pet");
            System.out.println("(c): Create Pet");
            System.out.println("(q): Quit");
            input = sc.nextLine();
            System.out.println();

            if (input.equals("p")) {
                System.out.println(player.petList());
                System.out.println("Which pet?");
                input = sc.nextLine();

                try {
                    int inputNum = Integer.parseInt(input);
                    if (inputNum <= player.getNumPets() && inputNum > 0) {
                        System.out.println("\n" + player.getPet(inputNum - 1).getStats());
                    } else {
                        System.out.println("\nInvalid input.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("\nInvalid input.");
                }

            } else if (input.equals("q")) {
                quit = true;

            } else if (input.equals("b")) {
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
                    System.out.println("\nInvalid input.");
                }

            } else if (input.equals("c")) {
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
                    System.out.println("\nInvalid input.");
                }

            } else {
                System.out.println("Invalid input.");
            }
        }
        sc.close();
    }
}