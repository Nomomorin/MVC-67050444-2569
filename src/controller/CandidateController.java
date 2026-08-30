package controller;

import java.util.List;

import model.Candidate;

public class CandidateController {
      private List<Candidate> candidates;

      public CandidateController(List<Candidate> candidates){
            this.candidates = candidates;
      }
      public List<Candidate> getCandidates() {
            return candidates;
      }
      
}
