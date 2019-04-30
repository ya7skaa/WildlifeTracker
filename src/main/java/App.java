
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
public class App {


    public static void main(String[] args){
        staticFileLocation("/public");
        String layout = "templates/layout.vtl";


        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("animals", Animals.all());
            model.put("endangeredAnimals", EndangeredAnimal.all());
            model.put("sightings", Sighting.all());
            model.put("template", "templates/index.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        //route when user clicks "Post Sighting"
        get("/sighting", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("animals", Animals.all());
            model.put("endangeredAnimals", EndangeredAnimal.all());
            model.put("template", "templates/sighting.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

    }


}
