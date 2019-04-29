import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EndangeredAnimalTest {
    @Test
    public void endangeredAnimal_instantiatesCorrectly_true() {
        EndangeredAnimal testEndangeredAnimal= new EndangeredAnimal();
        assertEquals(true, testEndangeredAnimal instanceof EndangeredAnimal);

    }

}
