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

    public static List<Sighting> all() {
        String sql = "SELECT id, ranger, location, animalId FROM sightings";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Sighting.class);
        }
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

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sightings (ranger, location, animalId ) VALUES (:ranger, :location, :animalId)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("ranger", this.ranger)
                    .addParameter("location", this.location)
                    .addParameter("animalId", this.animalId)
                    .executeUpdate()
                    .getKey();
        }
    }


}
