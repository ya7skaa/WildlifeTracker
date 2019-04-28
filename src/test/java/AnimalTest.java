import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnimalTest {
    @Test
    public void person_instantiatesCorrectly_true() {
        Animal testAnimal = new Animal("Lion","No");
        assertEquals(true, testAnimal instanceof Animal);

    }

    @Test
    public void getName_animalInstantiatesWithName_Lion() {
        Animal testAnimal = new Animal("Lion","No");
        assertEquals("Lion",testAnimal.getName());
    }

    @Test
    public void getEndangered_animalInstantiatesWithEndangered_No() {
        Animal testAnimal = new Animal("Lion","No");
        assertEquals("No",testAnimal.getEndangered());
    }

}


