import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class SightingTest {

    @Test
    public void sightingInstantiates_true(){
        Sighting testSighting = new Sighting();
        assertEquals(true, testSighting instanceof Sighting );
    }

}
