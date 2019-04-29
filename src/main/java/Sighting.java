import java.util.List;
import org.sql2o.*;

public class Sighting {
    private String ranger;
    private String location;
    private int id;
    private int animalId;

    public Sighting(String ranger, String location,int animalId){
        this.ranger = ranger;
        this.location = location;
        this.animalId = animalId;

    }
    public String getRanger() {
        return ranger;
    }

    public String getLocation(){
        return location;
    }

    public int getId(){
        return id;
    }
    public int getAnimalId(){
        return animalId;
    }

    @Override
    public boolean equals(Object otherSighting) {
        if (!(otherSighting instanceof Sighting)) {
            return false;
        } else {
            Sighting newSighting = (Sighting) otherSighting;
            return this.getRanger().equals(newSighting.getRanger()) &&
                    this.getLocation().equals(newSighting.getLocation())&&
                    this.getId() == newSighting.getId()&&
                    this.getAnimalId() == newSighting.getAnimalId();
        }
    }

}
