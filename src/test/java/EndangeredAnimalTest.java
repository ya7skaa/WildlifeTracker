import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EndangeredAnimalTest {
    @Test
    public void endangeredAnimal_instantiatesCorrectly_true(){
        EndangeredAnimal testAnimal = new EndangeredAnimal ("Lion","Healthy","old");
        assertEquals(true, testAnimal instanceof EndangeredAnimal);
    }


    @Test
    public void endangeredAnimal_getHealthInstantiatesCorrectly_String(){
        EndangeredAnimal testAnimal = new EndangeredAnimal("Lion","Healthy","old");
        assertEquals("Healthy", testAnimal.getHealth());
    }

    @Test
    public void endangeredAnimal_getAgeInstantiatesCorrectly_String(){
        EndangeredAnimal testAnimal = new EndangeredAnimal("Lion","healthy","old");
        assertEquals("old", testAnimal.getAge());
    }

    @Test
    public void save_InsertsObjectIntoDatabase_animal(){
        EndangeredAnimal testAnimal = new EndangeredAnimal("Lion","Healthy","old");
        testAnimal.save();
        assertTrue(EndangeredAnimal.all().get(0).equals(testAnimal));
    }

    @Test
    public void all_returnsAllInstancesOfAnimals_true(){
        EndangeredAnimal firstAnimal = new EndangeredAnimal("Lion","Healthy","old");
        firstAnimal.save();
        EndangeredAnimal secondAnimal = new EndangeredAnimal ("Lion","Healthy","old");
        secondAnimal.save();
        assertEquals(true, EndangeredAnimal.all().get(0).equals(firstAnimal));
        assertEquals(true, EndangeredAnimal.all().get(1).equals(secondAnimal));
    }

    @Test
    public void save_assignsIdToObject() {
        EndangeredAnimal testAnimal = new EndangeredAnimal ("Cheetahs","Healthy","Young");
        testAnimal.save();
        EndangeredAnimal savedAnimal = EndangeredAnimal.all().get(0);
        assertEquals(testAnimal.getId(), savedAnimal.getId());
    }



}