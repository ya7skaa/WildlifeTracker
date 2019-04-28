import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnimalTest {
    @Test
    public void person_instantiatesCorrectly_true() {
        Animal testAnimal = new Animal("Lion");
        assertEquals(true, testAnimal instanceof Animal);

    }

    @Test
    public void getName_personInstantiatesWithName_Lion() {
        Animal testAnimal = new Animal("Lion");
        assertEquals("Lion",testAnimal.getName());
    }
}


