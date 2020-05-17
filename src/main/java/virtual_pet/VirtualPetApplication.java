package virtual_pet;

import java.util.Random;
import java.util.Scanner;

public class VirtualPetApplication {

    public static void main(String[] args) {
        //Interact with a VirtualPet object in this method
        Scanner scanner = new Scanner(System.in);
        VirtualPet pet1 = new VirtualPet("Taz", 20, 24, 27, 15, 30);
        int failures = 0;
        System.out.println("Welcome to Virtual Pet Simulator!\n");
        System.out.println(pet1.getName() + " the cat is happy to see you!\n");
        System.out.println("   |\\---/|\n" +
                "   | ,_, |\n" +
                "    \\_`_/-..----.\n" +
                " ___/ `   ' ,\"\"+ \\  \n" +
                "(__...'   __\\    |`.___.';\n" +
                "  (_,...'(_,.`__)/'.....+");
        while (true) {
            boolean mischief = getMischief(pet1);
            int input;
            if (mischief) {
                failures++;
            }
            input = getPetStatus(scanner, pet1, mischief);
            input = getPetHelp(scanner, input);
            if (failures == 3) {
                System.out.println("YOU LOSE!");
                break;
            } else if (mischief) {
                System.out.println("You Lost a Turn!");
                continue;
            } else if (input == 0) {
                System.out.println("Exiting");
                break;
            } else {
                petInteraction(scanner, pet1, input);
            }
            System.out.println();
            pet1.tick();
        }
    }

    public static int getPetHelp(Scanner scanner, int input) {
        while ((input < 0) || (input > 5)) {
            System.out.println("Please enter a number between 0 and 5");
            input = scanner.nextInt();
        }
        return input;
    }

    public static boolean getMischief(VirtualPet pet) {
        if (pet.getBoredom() == 50) {
            System.out.println(pet.getName() + " tore up the couch.");
            pet.play(10);
            return true;
        } else if (pet.getHunger() == 50) {
            System.out.println(pet.getName() + " got into the pantry.");
            pet.feed(15);
            return true;
        } else if (pet.getThirst() == 50) {
            System.out.println(pet.getName() + " knocked over your cup.");
            pet.water(10);
            return true;
        } else if (pet.getLoneliness() == 50) {
            System.out.println(pet.getName() + " is hiding!");
            System.out.println("    |\\__/,|   (`\\\n" +
                    "  _.|o o  |_   ) )\n" +
                    "-(((---(((--------");
            pet.love(15);
            return true;
        } else if (pet.getEnergy() <= 15) {
            Random rand = new Random();
            int randSleep = 0;
            if (pet.getEnergy() != 0) {
                randSleep = rand.nextInt(pet.getEnergy());
            }
            if ((randSleep == 0)) {
                System.out.println(pet.getName() + " decided to take a nap.");
                System.out.println("      |\\      _,,,---,,_\n" +
                        "ZZZzz /,`.-'`'    -.  ;-;;,_\n" +
                        "     |,4-  ) )-,_. ,\\ (  `'-'\n" +
                        "    '---''(_/--'  `-'\\_)");
                pet.sleep(15);
                return true;
            }
        }
        return false;
    }

    public static void petInteraction(Scanner scanner, VirtualPet pet, int input) {
        if (input == 1) {
            feedPet(scanner, pet);
        } else if (input == 2) {
            pet.water(15);
            System.out.println("You water " + pet.getName());
        } else if (input == 3) {
            pet.play(20);
            pet.tired();
            System.out.println("You play with " + pet.getName());
        } else if (input == 4) {
            pet.love(15);
            if (pet.getLoneliness() % 2 == 0) {
                System.out.println("You cuddle with " + pet.getName());
            } else {
                System.out.println("You pet " + pet.getName());
            }
        } else if (input == 5) {
            pet.sleep(20);
            System.out.println("You took a nap with " + pet.getName());
        }
    }

    public static int getPetStatus(Scanner scanner, VirtualPet pet, boolean mischief) {
        if (mischief) {
            return 1;
        } else {
            System.out.println("Hunger: " + pet.getHunger() +
                    "\nThirst: " + pet.getThirst() +
                    "\nBoredom: " + pet.getBoredom() +
                    "\nLoneliness: " + pet.getLoneliness() +
                    "\nEnergy: " + pet.getEnergy());

            System.out.println();
            System.out.println("What would you like to do \n" +
                    "\n" +
                    "1: Feed\n" +
                    "2: Water\n" +
                    "3: Play\n" +
                    "4: Love\n" +
                    "5: Take a nap\n" +
                    "0: Exit");
            return scanner.nextInt();
        }
    }

    public static void feedPet(Scanner scanner, VirtualPet pet) {
        System.out.println("What would you like to feed Taz?\n" +
                "1: Treats\n" +
                "2: Wet Food\n" +
                "3: Dry Food");
        int input = scanner.nextInt();
        input = getFoodHelp(scanner, input);
        if (input == 1) {
            System.out.println(pet.getName() + " loved the treats!");
            pet.feed(5);
            pet.love(10);
        } else if (input == 2) {
            System.out.println(pet.getName() + " devoured the wet food!");
            pet.feed(10);
            pet.love(5);
        } else if (input == 3) {
            System.out.println(pet.getName() + "  ate all the dry food!");
            pet.feed(20);
        }
    }

    public static int getFoodHelp(Scanner scanner, int input) {
        while ((input < 1) || (input > 3)) {
            System.out.println("Please enter a number between 1 and 3");
            input = scanner.nextInt();
        }
        return input;
    }
}
