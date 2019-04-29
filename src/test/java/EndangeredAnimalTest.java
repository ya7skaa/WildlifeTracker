import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EndangeredAnimalTest {
    @Test
    public void endangeredAnimal_instantiatesCorrectly_true() {
        EndangeredAnimal testEndangeredAnimal= new EndangeredAnimal("Lion");
        assertEquals(true, testEndangeredAnimal instanceof EndangeredAnimal);

    }

    @Test
    public void getName_endangeredAnimalInstantiatesWithName_Lion() {
        EndangeredAnimal testEndangeredAnimal = new EndangeredAnimal("Lion");
        assertEquals("Lion",testEndangeredAnimal.getName());
    }


}
