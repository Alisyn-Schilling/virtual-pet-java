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
        hunger -= food;
    }

    public void water(int water) {
        thirst -= water;
    }

    public void play(int play) {
        boredom -= play;
    }

    public void love(int love) {
        loneliness -= love;
    }

    public void sleep(int sleep) {
        energy += sleep;
    }

    public void tick() {
        hunger += 2;
        thirst += 3;
        boredom += 5;
        loneliness += 4;
        energy -= 2;
    }

    public void tired() {
        hunger += 1;
        thirst += 3;
        energy -= 3;
    }
}
