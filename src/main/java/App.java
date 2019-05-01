
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

        port(5678);

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


        //route for adding an endangeredAnimal sighting

        post("/endangered_sighting", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String location = request.queryParams("location");
            String ranger = request.queryParams("ranger");
            String health = request.queryParams("health");
            String age = request.queryParams("health");

            int animalId = Integer.parseInt(request.queryParams("endangeredAnimalSelected"));
            Sighting sighting = new Sighting(ranger, location, animalId,health,age);
            sighting.save();
            model.put("sighting", sighting);
            model.put("animals", EndangeredAnimal.all());

            String animal = EndangeredAnimal.find(animalId).getName();
            model.put("animal", animal);
            model.put("template", "templates/success.vtl");
            return new ModelAndView(model, layout);
        },new VelocityTemplateEngine());


        // route for adding non-endangered animal sighting
        post("/sighting ", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String location = request.queryParams("location");
            String ranger = request.queryParams("ranger");
            String health = request.queryParams("health");
            String age = request.queryParams("health");

            int animalId = Integer.parseInt(request.queryParams("endangeredAnimalSelected"));
            Sighting sighting = new Sighting(ranger, location, animalId,health, age);
            sighting.save();
            model.put("sighting", sighting);
            model.put("animals", EndangeredAnimal.all());

            String animal = EndangeredAnimal.find(animalId).getName();
            model.put("animal", animal);
            model.put("template", "templates/success.vtl");
            return new ModelAndView(model, layout);
        },new VelocityTemplateEngine());


// route when clicking on "Add Animal to System"
        get("/animal/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/animal_form.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());


        // route for adding new animal form
        post("/animal/new", (request, response) -> {
            boolean endangered = request.queryParams("endangered")!=null;
            if (endangered) {
                String name = request.queryParams("name");
                String health = request.queryParams("health");
                String age = request.queryParams("health");
                EndangeredAnimal animal = new EndangeredAnimal(name,health,age);
                animal.save();
            } else {
                String name = request.queryParams("name");
                Animals animal = new Animals(name);
                animal.save();
            }
            response.redirect("/");
            return null;
        });


        //route when user clicks "All Animals" or "View Animals"
        get("/animals", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("animals", Animals.all());
            model.put("endangeredAnimals", EndangeredAnimal.all());
            model.put("sightings", Sighting.all());
            model.put("template", "templates/animals.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        //route when you click on an endangeredAnimal

        get("/endangered_animal/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            EndangeredAnimal endangeredAnimal = EndangeredAnimal.find(Integer.parseInt(request.params("id")));
            model.put("endangeredAnimal", endangeredAnimal);
            model.put("template", "templates/endangered_animal.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());


        //route when you click on a non-endangered animal

        get("/animal/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Animals animal = Animals.find(Integer.parseInt(request.params("id")));
            model.put("animal", animal);
            model.put("template", "templates/animal.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());




//        post("/endangered_sighting", (request, response) -> {
//            Map<String, Object> model = new HashMap<String, Object>();
//            int animalId = Integer.parseInt(request.queryParams("endangeredAnimalSelected"));
//            String health = request.queryParams("health");
//            String age = request.queryParams("age");
//            String location = request.queryParams("location");
//            String ranger = request.queryParams("ranger");
//            Sighting sighting = new Sighting(ranger, location, animalId);
//            sighting.save();
//            // model.put("sighting", sighting);
//            // model.put("animals", EndangeredAnimal.all());
//            String animal = EndangeredAnimal.find(animalId).getName();
//            int selectAnimalId = Integer.parseInt(request.queryParams("endangeredAnimalSelected"));
//            EndangeredAnimal updatedAnimal = EndangeredAnimal.find(animalId);
//            updatedAnimal.update(health, age);
//            model.put("animal", animal);
//            model.put("template", "templates/success.vtl");
//            return new ModelAndView(model, layout);
//        }, new VelocityTemplateEngine());

    }


}
