package model;


public class Voter {
    private final String id;
    private String name;
    private Boolean active;

    public Voter(String id, String name, boolean active) {
        this.id = id;
        this.name = name;
        this.active = active;
    }

    public String getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public Boolean getActive() {
        return active;
    }


}
