import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class SightingTest {

    @Test
    public void sightingInstantiates_true(){
        Sighting testSighting = new Sighting("Yasmin","Karura Forest",1);
        assertEquals(true, testSighting instanceof Sighting );
    }
    @Test
    public void getRangerInstantiatesCorrectly_String(){
        Sighting testSighting = new Sighting("Yasmin","Karura Forest",1);
        assertEquals("Yasmin", testSighting.getRanger());
    }
    @Test
    public void getLocationInstantiatesCorrectly_String(){
        Sighting testSighting = new Sighting("Yasmin","Karura Forest",1);
        assertEquals("Karura Forest", testSighting.getLocation());
    }
    @Test
    public void equals_returnsTrueIfRangerAreTheSame_true() {
        Sighting firstSighting = new Sighting("Yasmin","Karura Forest",1);
        Sighting secondSighting = new Sighting("Jack","Park",1);
        assertTrue(firstSighting.equals(secondSighting));
    }
    @Test
    public void save_savesIntoDatabase_true() {
        Sighting mySighting = new Sighting("Yasmin","Karura Forest",1);
        mySighting.save();
        assertTrue(Sighting.all().get(0).equals(mySighting));
    }



}
