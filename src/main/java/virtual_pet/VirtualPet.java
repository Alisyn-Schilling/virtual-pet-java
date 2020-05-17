package virtual_pet;

public class VirtualPet {
    private final String name;
    private int hunger;
    private int thirst;
    private int boredom;
    private int loneliness;
    private int energy;

    public VirtualPet(String name, int hunger, int thirst, int boredom, int loneliness, int energy) {
        this.name = name;
        this.hunger = hunger;
        this.thirst = thirst;
        this.boredom = boredom;
        this.loneliness = loneliness;
        this.energy = energy;
    }

    public String getName() {
        return name;
    }

    public int getHunger() {
        return hunger;
    }

    public int getThirst() {
        return thirst;
    }

    public int getBoredom() {
        return boredom;
    }

    public int getLoneliness() {
        return loneliness;
    }

    public int getEnergy() {
        return energy;
    }

    public void feed(int food) {
        if ((hunger - food) > 0) {
            hunger -= food;
        } else {
            hunger = 0;
        }
    }

    public void water(int water) {
        if ((thirst - water) > 0) {
            thirst -= water;
        } else {
            thirst = 0;
        }
    }

    public void play(int play) {
        if ((boredom - play) > 0) {
            boredom -= play;
        } else {
            boredom = 0;
        }
    }

    public void love(int love) {
        if ((loneliness - love) > 0) {
            loneliness -= love;
        } else {
            loneliness = 0;
        }
    }

    public void sleep(int sleep) {
        if ((energy + sleep) < 50) {
            energy += sleep;
        } else {
            energy = 50;
        }
    }

    public void tick() {
        if ((hunger + 2) < 50) {
            hunger += 2;
        } else {
            hunger = 50;
        }
        if ((thirst + 3) < 50) {
            thirst += 3;
        } else {
            thirst = 50;
        }
        if ((boredom + 5) < 50) {
            boredom += 5;
        } else {
            boredom = 50;
        }
        if ((loneliness + 4) < 50) {
            loneliness += 4;
        } else {
            loneliness = 50;
        }
        if ((energy - 2) > 0) {
            energy -= 2;
        } else {
            energy = 0;
        }
    }

    public void tired() {
        if ((hunger + 1) < 50) {
            hunger += 1;
        } else {
            hunger = 50;
        }
        if ((thirst + 3) < 50) {
            thirst += 3;
        } else {
            thirst = 50;
        }
        if ((energy - 3) > 0) {
            energy -= 3;
        } else {
            energy = 0;
        }
    }
}
