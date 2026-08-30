package view;

import java.util.Scanner;

import controller.ApplicationController;
import model.Candidate;

public class CandidateView {
      public void showCandidates(ApplicationController controller) {
            System.out.println(" Candidate:");
            for (Candidate candidate : controller.getCandidates()) {
                  System.out.println( candidate.getId() + " | " + candidate.getName());
            }
      }
}
