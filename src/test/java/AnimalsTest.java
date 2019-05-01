import org.junit.Rule;
import org.junit.Test;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static junit.framework.TestCase.assertTrue;


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
    public void all_returnsAllInstancesOfAnimals_true() {
        Animals firstAnimals = new Animals("Lion");

        firstAnimals.save();
        Animals secondAnimals = new Animals("Rhino");
        secondAnimals.save();
        assertEquals(true, Animals.all().get(0).equals(firstAnimals));
        assertEquals(true, Animals.all().get(1).equals(secondAnimals));
    }

    @Test
    public void save_assignsIdToObject() {
        Animals testAnimals = new Animals("Lion");
        testAnimals.save();
        Animals savedAnimals = Animals.all().get(0);
        assertEquals(testAnimals.getId(), savedAnimals.getId());
    }

    @Test
    public void find_returnsPersonWithSameId_secondPerson() {
        Animals firstAnimals = new Animals("Lion");
        firstAnimals.save();
        Animals secondAnimals = new Animals("Rhino");
        secondAnimals.save();
        assertEquals(Animals.find(secondAnimals.getId()), secondAnimals);
    }

    @Test
    public void getSightings_retrievesALlSightingsFromDatabase_sightingsList() {
        Animals myAnimal = new Animals("Lion");
        myAnimal.save();
        Sighting firstSighting = new Sighting("John","By the river", myAnimal.getId(),"Sick","Young");
        firstSighting.save();
        Sighting secondSighting = new Sighting("Peter","By the pond", myAnimal.getId(),"Sick","Young");
        secondSighting.save();
        Sighting[] sightings = new Sighting[] { firstSighting, secondSighting };
        assertTrue(myAnimal.getSightings().containsAll(Arrays.asList(sightings)));
    }



}


