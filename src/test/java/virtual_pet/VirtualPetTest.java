package virtual_pet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VirtualPetTest {

    @Test
    public void createVirtualPet() {
        VirtualPet pet1 = new VirtualPet("Taz", 20, 21, 22, 23, 24);
    }

    @Test
    public void getPetName() {
        VirtualPet pet1 = new VirtualPet("Taz", 20, 21, 22, 23, 24);
        assertEquals("Taz", pet1.getName());
    }

    @Test
    public void getPetHunger() {
        VirtualPet pet1 = new VirtualPet("Taz", 20, 21, 22, 23, 24);
        assertEquals(20, pet1.getHunger());
    }

    @Test
    public void getPetThirst() {
        VirtualPet pet1 = new VirtualPet("Taz", 20, 21, 22, 23, 24);
        assertEquals(21, pet1.getThirst());
    }

    @Test
    public void getPetBoredom() {
        VirtualPet pet1 = new VirtualPet("Taz", 20, 21, 22, 23, 24);
        assertEquals(22, pet1.getBoredom());
    }

    @Test
    public void getPetLoneliness() {
        VirtualPet pet1 = new VirtualPet("Taz", 20, 21, 22, 23, 24);
        assertEquals(23, pet1.getLoneliness());
    }

    @Test
    public void getPetEnergy() {
        VirtualPet pet1 = new VirtualPet("Taz", 20, 21, 22, 23, 24);
        assertEquals(24, pet1.getEnergy());
    }

    @Test
    public void feedPet() {
        VirtualPet pet1 = new VirtualPet("Taz", 20, 21, 22, 23, 24);
        pet1.feed(5);
        assertEquals(15, pet1.getHunger());
    }

    @Test
    public void waterPet() {
        VirtualPet pet1 = new VirtualPet("Taz", 20, 21, 22, 23, 24);
        pet1.water(3);
        assertEquals(18, pet1.getThirst());
    }

    @Test
    public void playWithPet() {
        VirtualPet pet1 = new VirtualPet("Taz", 20, 21, 22, 23, 24);
        pet1.play(10);
        assertEquals(12, pet1.getBoredom());
    }

    @Test
    public void cuddleWithPet() {
        VirtualPet pet1 = new VirtualPet("Taz", 20, 21, 22, 23, 24);
        pet1.love(12);
        assertEquals(11, pet1.getLoneliness());
    }

    @Test
    public void sleepPet() {
        VirtualPet pet1 = new VirtualPet("Taz", 20, 21, 22, 23, 24);
        pet1.sleep(25);
        assertEquals(49, pet1.getEnergy());
    }

    @Test
    public void tickPet() {
        VirtualPet pet1 = new VirtualPet("Taz", 20, 21, 22, 23, 24);
        pet1.tick();
        assertEquals(22, pet1.getHunger());
        assertEquals(24, pet1.getThirst());
        assertEquals(27, pet1.getBoredom());
        assertEquals(27, pet1.getLoneliness());
        assertEquals(22, pet1.getEnergy());
    }

    @Test
    public void tiredPet() {
        VirtualPet pet1 = new VirtualPet("Taz", 20, 21, 22, 23, 24);
        pet1.tired();
        assertEquals(21, pet1.getHunger());
        assertEquals(24, pet1.getThirst());
        assertEquals(21, pet1.getEnergy());
    }

}
