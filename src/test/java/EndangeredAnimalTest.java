import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EndangeredAnimalTest {
    @Test
    public void animal_instantiatesCorrectly_true(){
        EndangeredAnimal testAnimal = new EndangeredAnimal ("Lion","No","Healthy","old");
        assertEquals(true, testAnimal instanceof EndangeredAnimal);
    }


    @Test
    public void endangeredAnimal_getHealthInstantiatesCorrectly_String(){
        EndangeredAnimal testAnimal = new EndangeredAnimal("Lion","No","Healthy","old");
        assertEquals("Healthy", testAnimal.getHealth());
    }

    @Test
    public void endangeredAnimal_getAgeInstantiatesCorrectly_String(){
        EndangeredAnimal testAnimal = new EndangeredAnimal("Lion","No","healthy","old");
        assertEquals("Young", testAnimal.getAge());
    }


}