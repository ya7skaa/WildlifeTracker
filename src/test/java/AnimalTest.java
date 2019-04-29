import org.junit.Test;
import org.sql2o.*;

import static org.junit.Assert.assertEquals;

public class AnimalTest {
    @Test
    public void person_instantiatesCorrectly_true() {
        Animal testAnimal = new Animal("Lion");
        assertEquals(true, testAnimal instanceof Animal);

    }

    @Test
    public void getName_animalInstantiatesWithName_Lion() {
        Animal testAnimal = new Animal("Lion");
        assertEquals("Lion",testAnimal.getName());
    }



}


