import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnimalTest {
    @Test
    public void person_instantiatesCorrectly_true() {
        Animal testAnimal = new Animal();
        assertEquals(true, testAnimal instanceof Animal);

    }
}


