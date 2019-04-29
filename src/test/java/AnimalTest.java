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

    @Test
    public void save_insertsObjectIntoDatabase_Animal() {
        Animal testAnimal = new Animal("Lion");
        testAnimal.save();
        assertTrue(Animal.all().get(0).equals(testAnimal));
    }



}


