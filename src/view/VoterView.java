package view;

import java.util.Scanner;

import controller.ApplicationController;
import model.Voter;

public class VoterView {
      public void showVoter(ApplicationController controller) {
            System.out.println("\nVoters:");
            for (Voter voter : controller.getVoter()) {
                  System.out.println( voter.getId() + " | " + voter.getName());
            }
      }


      public void showVoter(ApplicationController controller, String id) {
            System.out.println("\nVoters:");
            Voter voter =  controller.getVoterByID(id);
                  System.out.println( voter.getId() + " | " + voter.getName());

      }
}
