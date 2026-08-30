package controller;

import java.util.List;

import model.Ballot;

public class BallotController {
      private List<Ballot> Ballots;

      public BallotController(List<Ballot> Ballots){
            this.Ballots = Ballots;
      }
      public List<Ballot> getBallots() {
            return Ballots;
      }

      public Boolean createBallot(String idVoter, String[] ranking){
            Ballot ballot = new Ballot("B"+(Ballots.size()+1), idVoter, ranking);
            Ballots.add(ballot);
            return true;
      }

      
      public boolean isHaveBallot(String id){
            for (Ballot ballot : Ballots) {
                  if (ballot.getVoter_id().equalsIgnoreCase(id)){
                        return true;
                  }
            }
            return false;
      }

}
