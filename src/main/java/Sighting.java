import java.util.List;
import org.sql2o.*;

public class Sighting {
    private String ranger;
    private String location;

    public Sighting(String ranger, String location){
        this.ranger = ranger;
        this.location = location;

    }
    public String getRanger() {
        return ranger;
    }

    public String getLocation(){
        return location;
    }

}
