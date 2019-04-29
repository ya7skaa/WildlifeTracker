import org.sql2o.*;

public class Animals {


    public String name;



    public Animals(String name){
        this.name = name;



    }

    public String getName() {
        return name;
    }



    @Override
    public boolean equals(Object otherAnimal) {
        if (!(otherAnimal instanceof Animals)) {
            return false;
        } else {
            Animals newAnimals = (Animals) otherAnimal;
            return this.getName().equals(newAnimals.getName());

        }
    }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name ) VALUES (:name)";
            con.createQuery(sql)
                    .addParameter("name", this.name)

                    .executeUpdate();
        }
    }



}
