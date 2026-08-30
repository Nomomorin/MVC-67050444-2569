package view;

import java.util.Scanner;

import controller.ApplicationController;
import model.Candidate;


public class MainView {
    private final Scanner scanner = new Scanner(System.in);
    SelectView selectView = new SelectView();
    VoterView voterView = new VoterView();
    ElectionView electionView = new ElectionView();
    CandidateView candidateView = new CandidateView();
    int sessionRole = 0;
    String sessionIdLogin = "";
    String sessionIdElection = "";
    ApplicationController controller;
    public MainView(ApplicationController controller) {
        this.controller = controller;
        
    }

    public void start() {
        System.out.println(" ระบบเลือกตั้งประธานชมรม - ชมรมโปร่งใสจริง ๆ นะ ");

        while (true) {
            sessionRole = selectView.SelectRole(scanner);
            if (sessionRole == 3) {
                System.out.println("Thank you!");
                return;
            }
            if(sessionRole == 1){
                voterView.showVoter(controller);
                sessionIdLogin = selectView.LoginVoter(scanner);
                if (controller.isHaveBallot(sessionIdLogin)){
                    return;
                }
                if (!(controller.voterIsActive(sessionIdLogin))) {
                    return ;
                }
                electionView.showElection(controller);
                sessionIdElection = selectView.SelectElection(scanner);
                if (!(controller.electioIsOpen(sessionIdElection))) {
                    return ;
                }
                candidateView.showCandidates(controller);
                String[] vote = new String[3];
                System.out.println("\nVoters:");
                for (int i = 1; i < vote.length+1; i++) {
                    System.out.println("\n No." + i +" Select id candidate: ");
                    vote[i-1] =  scanner.nextLine().trim();
                }
                boolean s = controller.createBallot(sessionIdLogin, vote);
                if(s){
                    System.out.println("\nBallot:");
                    electionView.showElectionByID(controller, sessionIdElection);
                    voterView.showVoter(controller, sessionIdLogin);
                    System.out.println("vote : ");
                    for (int i = 0; i < vote.length; i++) {
                        System.out.print(" No ."+ (i+1) + vote[i]);
                    }
                    System.out.println();
                }
            }
/*             showCandidates();
            showOpenJobs();

            System.out.print("\nCandidate ID (or EXIT): ");
            String candidateId = scanner.nextLine().trim();
            if (candidateId.equalsIgnoreCase("EXIT")) {
                System.out.println("Bye");
                return;
            }

            System.out.print("Job ID: ");
            String jobId = scanner.nextLine().trim();

            Result<Application> result = controller.apply(candidateId, jobId, today);
            System.out.println("\nResult: " + result.getMessage());
            System.out.println("------------------------------"); */
        }
    }

/*     private void showCandidates() {
        System.out.println("\nCandidates:");
        for (Candidate candidate : controller.getCandidates()) {
            System.out.println(
                    candidate.getId() + " | "
                            + candidate.getName() + " | "
                            + candidate.getStatus());
        }
    }

    private void showOpenJobs() {
        System.out.println("\nOpen Jobs:");
        for (Job job : controller.getOpenJobs()) {
            System.out.println(
                    job.getId() + " | "
                            + job.getName() + " | "
                            + job.getType() + " | deadline="
                            + job.getDeadline());
        }
    } */
}