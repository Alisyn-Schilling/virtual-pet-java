package virtual_pet;

import java.util.Random;
import java.util.Scanner;

public class VirtualPetApplication {

    public static void main(String[] args) {
        //Interact with a VirtualPet object in this method
        Scanner scanner = new Scanner(System.in);
        VirtualPet pet1 = new VirtualPet("Taz", 20, 24, 27, 15, 30);
        System.out.println("Welcome to Virtual Pet Simulator!\n");
        System.out.println(pet1.getName() + " the cat is happy to see you!\n");
        while (true) {
            boolean mischief = false;
            if (pet1.getBoredom() >= 50) {
                System.out.println(pet1.getName() + " tore up the couch.");
                pet1.play(10);
                mischief = true;
            } else if (pet1.getHunger() >= 50) {
                System.out.println(pet1.getName() + " got into the pantry.");
                pet1.feed(15);
                mischief = true;
            } else if (pet1.getThirst() >= 50){
                System.out.println(pet1.getName() + " knocked over your cup.");
                pet1.water(10);
                mischief = true;
            } else if (pet1.getLoneliness() >= 50) {
                System.out.println(pet1.getName() + " is hiding!");
                pet1.love(15);
                mischief = true;
            } else if (pet1.getEnergy() <= 10){
                Random rand = new Random();
                int randSleep = rand.nextInt(pet1.getEnergy());
                if (randSleep == 0) {
                    System.out.println(pet1.getName() + " decided to take a nap.");
                    pet1.sleep(15);
                    mischief = true;
                }
            }
            int input = 1;
            if (mischief){
                System.out.println(pet1.getName() + " isn't happy. Lost a turn.\n");
            } else {
                System.out.println("Hunger: " + pet1.getHunger() +
                        "\nThirst: " + pet1.getThirst() +
                        "\nBoredom: " + pet1.getBoredom() +
                        "\nLoneliness: " + pet1.getLoneliness() +
                        "\nEnergy: " + pet1.getEnergy());

                System.out.println();
                System.out.println("What would you like to do \n" +
                        "\n" +
                        "1: Feed\n" +
                        "2: Water\n" +
                        "3: Play\n" +
                        "4: Love\n" +
                        "5: Take a nap\n" +
                        "0: Exit");
                input = scanner.nextInt();
            }
            while ((input < 0) || (input > 5)) {
                System.out.println("Please enter a number between 0 and 5");
                input = scanner.nextInt();
            }
            if (mischief){
              continue;
            } else if (input == 0) {
                break;
            } else if (input == 1) {
                pet1.feed(20);
                System.out.println("You feed " + pet1.getName());
            } else if (input == 2) {
                pet1.water(15);
                System.out.println("You water " + pet1.getName());
            } else if (input == 3) {
                pet1.play(20);
                pet1.tired();
                System.out.println("You play with " + pet1.getName());
            } else if (input == 4) {
                pet1.love(15);
                if (pet1.getLoneliness() % 2 == 0) {
                    System.out.println("You cuddle with " + pet1.getName());
                } else {
                    System.out.println("You pet " + pet1.getName());
                }
            } else if (input == 5){
                pet1.sleep(20);
                System.out.println("You took a nap with " + pet1.getName());
            }
            System.out.println();
            pet1.tick();
        }
    }
}
