import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnimalsTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void person_instantiatesCorrectly_true() {
        Animals testAnimals = new Animals("Lion");
        assertEquals(true, testAnimals instanceof Animals);

    }

    @Test
    public void getName_animalInstantiatesWithName_Lion() {
        Animals testAnimals = new Animals("Lion");
        assertEquals("Lion", testAnimals.getName());
    }

    @Test
    public void save_insertsObjectIntoDatabase_Animal() {
        Animals testAnimals = new Animals("Lion");
        testAnimals.save();
        assertEquals(Animals.all().get(0).equals(testAnimals));
    }



}


