package model;

public class Ballot {
    private final String id;
    private final String voter_id;
    private String[] ranking;
    private BallotStatus status = BallotStatus.NOCHECK;

    public Ballot(String id, String voter_id, String[] ranking) {
        this.id = id;
        this.voter_id = voter_id;
        this.ranking = ranking;
    }

    public String getId() {
        return id;
    }

    public String getVoter_id() {
        return voter_id;
    }

    public String[] getRanking() {
        return ranking;
    }

    public void setStatus(BallotStatus status) {
        this.status = status;
    }

    public BallotStatus getStatus() {
        return status;
    }

}
