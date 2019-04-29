public class  EndangeredAnimal extends Animals {
   private String  health;
   private  String age;



    public static final String HEALTH = "healthy";
    public static final String ILL = "ill";
    public static final String OKAY = "okay";
    public static final String NEWBORN = "newborn";
    public static final String YOUNG = "young";
    public static final String ADULT = "adult";




    public EndangeredAnimal(String name, String health, String age) {
        super(name);
        this.health = health;
        this.age = age;
    }

    public String getHealth() {
        return health;
    }

    public String getAge() {
        return age;
    }

}
