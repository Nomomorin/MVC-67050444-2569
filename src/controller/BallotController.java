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

      public void CheckBallot() {
            for (Ballot ballot : Ballots) {
                  int count = 0;
                  for (Ballot checkBallot : Ballots) {
                        if (Arrays.equals(
                                    ballot.getRanking(),
                                    checkBallot.getRanking())) {
                              count++;
                        }
                  }
                  if (count >= 3) {
                        for (Ballot checkBallot : Ballots) {
                              if (Arrays.equals(
                                          ballot.getRanking(),
                                          checkBallot.getRanking())) {

                                    checkBallot.setStatus(BallotStatus.PENDING);
                              }
                        }
                  }
            }
      }

      public Map<String, Integer> calculateScore() {

            Map<String, Integer> scores = new HashMap<>();

            int[] points = { 3, 2, 1 };

            for (Ballot ballot : Ballots) {
                  if (ballot.getStatus() == BallotStatus.PENDING) {
                        continue;
                  }
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
