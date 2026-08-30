package view;

import java.util.Scanner;

import controller.ApplicationController;
import model.Election;
import model.Voter;

public class ElectionView {
      public void showElection(ApplicationController controller) {
            System.out.println("\n Election:");
            for (Election election : controller.getElections()) {
                  System.out.println( election.getId() + " | " + election.gettitle() + " | " + election.getStatus());
            }
      }

      public void showElectionByID(ApplicationController controller, String id) {
            System.out.println("\n Election:");
            Election election = controller.getElectionByID(id);
                  System.out.println( election.getId() + " | " + election.gettitle() + " | " + election.getStatus());
            
      }
}
