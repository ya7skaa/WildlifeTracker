import java.util.List;
import org.sql2o.*;

public class Sighting {
    private String ranger;

    public Sighting(String ranger){
        this.ranger = ranger;

    }
    public String getRanger() {
        return ranger;
    }

}
