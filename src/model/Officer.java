package model;


public class Officer {
    private final String id;
    private String name;

    public Officer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }


    public String getName() {
        return name;
    }


}
