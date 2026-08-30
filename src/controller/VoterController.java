package controller;

import java.util.List;

import model.Election;
import model.Voter;

public class VoterController {
      private List<Voter> Voters;

      public VoterController(List<Voter> Voters){
            this.Voters = Voters;
      }
      public List<Voter> getVoter() {
            return Voters;
      }

      public boolean isActive(String id){
            for (Voter voter : Voters) {
                  if (voter.getId().equalsIgnoreCase(id)) {
                        return voter.getActive();
                  } 
            }
            return false;
      }

      public Voter getVoterByID(String id) {
            for (Voter voter : Voters) {
                  if (voter.getId().equalsIgnoreCase(id)) {
                        return voter;
                  } 
            }
            return null;
      }
}
