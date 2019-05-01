import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class SightingTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void sightingInstantiates_true(){
        Sighting testSighting = new Sighting("Yasmin","Karura Forest",1,"Healthy","old");
        assertEquals(true, testSighting instanceof Sighting );
    }
    @Test
    public void getRangerInstantiatesCorrectly_String(){
        Sighting testSighting = new Sighting("Yasmin","Karura Forest",1,"Healthy","old");
        assertEquals("Yasmin", testSighting.getRanger());
    }
    @Test
    public void getLocationInstantiatesCorrectly_String(){
        Sighting testSighting = new Sighting("Yasmin","Karura Forest",1,"Healthy","old");
        assertEquals("Karura Forest", testSighting.getLocation());
    }
    @Test
    public void equals_returnsTrueIfRangerAreTheSame_true() {
        Sighting firstSighting = new Sighting("Yasmin","Karura Forest",1,"Healthy","old");
        Sighting secondSighting = new Sighting("Yasmin","Karura Forest",1,"Healthy","old");
        assertTrue(firstSighting.equals(secondSighting));
    }
    @Test
    public void save_savesIntoDatabase_true() {
        Sighting mySighting = new Sighting("Yasmin","Karura Forest",1,"Healthy","old");
        mySighting.save();
        assertTrue(Sighting.all().get(0).equals(mySighting));
    }
    @Test
    public void all_returnsAllInstancesOfSighting_true() {
        Sighting firstSighting = new Sighting("Yasmin","Karura Forest",1,"Healthy","old");
        firstSighting.save();
        Sighting secondSighting = new Sighting("Peter","By the pond",1,"Healthy","old");
        secondSighting.save();
        assertEquals(true, Sighting.all().get(0).equals(firstSighting));
        assertEquals(true, Sighting.all().get(1).equals(secondSighting));
    }

    @Test
    public void save_assignsIdToObject() {
        Sighting mySighting = new Sighting("Yasmin","Karura Forest",1,"Healthy","old");
        mySighting.save();
        Sighting savedSighting = Sighting.all().get(0);
        assertEquals(mySighting.getId(), savedSighting.getId());
    }
    @Test
    public void getId_sightingsInstantiateWithAnId_1() {
        Sighting testSighting = new Sighting("Yasmin","Karura Forest",1,"Healthy","old");
        testSighting.save();
        assertTrue(testSighting.getId() > 0);
    }

    @Test
    public void find_returnsSightingsWithSameId_secondSighting() {
        Sighting firstSighting = new Sighting("Yasmin","Karura Forest",1,"Healthy","old");
        firstSighting.save();
        Sighting secondSighting = new Sighting("Yasmin","Karura Forest",1,"Healthy","old");
        secondSighting.save();
        assertEquals(Sighting.find(secondSighting.getId()), secondSighting);
        assertEquals(Sighting.find(firstSighting.getId()), firstSighting);
    }

    @Test
    public void save_savesAnimalsIdIntoDB_true() {
        Animals myAnimal = new Animals("Lion");
        myAnimal.save();
        Sighting mySighting = new Sighting("Yasmin", "Karura Forest", myAnimal.getId(),"Healthy","old");
        mySighting.save();
        Sighting savedSighting = Sighting.find(mySighting.getId());
        assertEquals(savedSighting.getAnimalId(), myAnimal.getId());
    }




}
