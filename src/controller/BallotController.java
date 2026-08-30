package controller;

import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import model.Ballot;
import model.BallotStatus;

public class BallotController {
      private List<Ballot> Ballots;

      public BallotController(List<Ballot> Ballots) {
            this.Ballots = Ballots;
      }

      public List<Ballot> getBallots() {
            return Ballots;
      }

      public Boolean createBallot(String idVoter, String[] ranking) {
            Ballot ballot = new Ballot("B" + (Ballots.size() + 1), idVoter, ranking);
            Ballots.add(ballot);
            return true;
      }

      public boolean isHaveBallot(String id) {
            for (Ballot ballot : Ballots) {
                  if (ballot.getVoter_id().equalsIgnoreCase(id)) {
                        return true;
                  }
            }
            return false;
      }

      public void add(Ballot ballot) {
            for (int i = 0; i < Ballots.size(); i++) {
                  Ballot CheckBallot = Ballots.get(i);
                  if (Arrays.equals(
                              CheckBallot.getRanking(),
                              ballot.getRanking())) {
                        CheckBallot.setStatus(BallotStatus.PENDING);
                        ballot.setStatus(BallotStatus.PENDING);
                  }
            }
            Ballots.add(ballot);
      }

      public Map<String, Integer> calculateScore() {

            Map<String, Integer> scores = new HashMap<>();

            int[] points = { 3, 2, 1 };

            for (Ballot ballot : Ballots) {

                  String[] ranking = ballot.getRanking();

                  for (int i = 0; i < ranking.length; i++) {

                        String candidateId = ranking[i];
                        int point = points[i];

                        scores.put(
                                    candidateId,
                                    scores.getOrDefault(candidateId, 0) + point);
                  }
            }

            return scores;
      }

}
