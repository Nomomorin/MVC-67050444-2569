package model;


public class Election {
    private final String id;
    private final String title;
    private ElectionStatus status;
    //private int[] ranking_points = new int[3, 2, 1];
    private int duplicate_pattern_threshold = 3;

    public Election(String id,String title,ElectionStatus status) {
        this.id = id;
        this.title = title;
        this.status = status;
    }

    public String getId() {
        return id;
    }


    public String gettitle() {
        return title;
    }


    public ElectionStatus getStatus() {
        return status;
    }

    public void setStatus(ElectionStatus status) {
        this.status = status;
    }


}
