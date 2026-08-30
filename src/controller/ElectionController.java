package controller;

import java.util.List;

import model.Election;
import model.ElectionStatus;

public class ElectionController {
      private List<Election> Elections;

      public ElectionController(List<Election> Elections){
            this.Elections = Elections;
      }
      public List<Election> getElections() {
            return Elections;
      }

        public Election getElectionByID(String id) {
            for (Election election : Elections) {
                  if (election.getId().equalsIgnoreCase(id)) {
                        return election;
                  } 
            }
            return null;
      }

      public boolean electioIsOpen(String id){
             for (Election election : Elections) {
                  if (election.getId().equalsIgnoreCase(id)) {
                        return election.getStatus() == ElectionStatus.OPEN;
                  } 
            }
            return false;
      }
      
}
