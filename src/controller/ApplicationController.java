package controller;

import java.util.Map;
import java.util.ArrayList;
import java.util.List;

import model.Ballot;
import model.BallotStatus;
import model.Candidate;
import model.Election;
import model.Officer;
import model.Voter;

public class ApplicationController {
      private ElectionController electionController;
      private BallotController ballotController;
      private List<Officer> Officers;
      private VoterController voterController;
      private CandidateController candidateController;

      public ApplicationController(
                  List<Ballot> Ballots,
                  List<Candidate> Candidates,
                  List<Election> Elections,
                  List<Officer> Officers,
                  List<Voter> Voters) {
            this.ballotController = new BallotController(Ballots);
            this.candidateController = new CandidateController(Candidates);
            this.electionController = new ElectionController(Elections);
            this.Officers = Officers;
            this.voterController = new VoterController(Voters);
      }

      public List<Voter> getVoter() {
            return voterController.getVoter();
      }

      public List<Candidate> getCandidates() {
            return candidateController.getCandidates();
      }

      public boolean voterIsActive(String id) {
            return voterController.isActive(id);
      }

      public List<Election> getElections() {
            return electionController.getElections();
      }

      public List<Ballot> getBallots() {
            return ballotController.getBallots();
      }

      public boolean electioIsOpen(String id) {
            return electionController.electioIsOpen(id);
      }

      public Election getElectionByID(String id) {
            return electionController.getElectionByID(id);
      }

      public boolean createBallot(String idVoter, String[] ranking) {
            return ballotController.createBallot(idVoter, ranking);
      }

      public Voter getVoterByID(String id) {
            return voterController.getVoterByID(id);
      }

      public boolean isHaveBallot(String id) {
            return ballotController.isHaveBallot(id);
      }

      public void closeElection(String id) {
            electionController.closeElection(id);
      }

      public Map<String, Integer> calculateScore() {
            return ballotController.calculateScore();
      }

      public void CheckBallot() {
            ballotController.CheckBallot();
      }

      public List<String> getPendingGroups() {
            return ballotController.getPendingGroups();
      }

      public boolean reviewPendingGroup(String selectedGroup,
                  int decision){
            return ballotController.reviewPendingGroup(selectedGroup, decision);
      }
}