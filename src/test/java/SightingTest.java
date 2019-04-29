import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class SightingTest {

    @Test
    public void sightingInstantiates_true(){
        Sighting testSighting = new Sighting("Yasmin","Karura Forest");
        assertEquals(true, testSighting instanceof Sighting );
    }
    @Test
    public void getRangerInstantiatesCorrectly_String(){
        Sighting testSighting = new Sighting("Yasmin","Karura Forest");
        assertEquals("Yasmin", testSighting.getRanger());
    }
    @Test
    public void getLocationInstantiatesCorrectly_String(){
        Sighting testSighting = new Sighting("Yasmin","Karura Forest");
        assertEquals("By the river", testSighting.getLocation());
    }



}
