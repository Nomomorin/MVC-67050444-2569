package view;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import controller.ApplicationController;
import model.Ballot;
import model.Election;

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
            if (sessionRole == 1) {
                voterView.showVoter(controller);
                sessionIdLogin = selectView.LoginVoter(scanner);
                if (controller.isHaveBallot(sessionIdLogin)) {
                    System.out.println("ลงคะแนนแล้ว");
                    continue;
                }
                if (!(controller.voterIsActive(sessionIdLogin))) {
                    System.out.println("Voter is not active");
                    continue;
                }
                electionView.showElection(controller);
                sessionIdElection = selectView.SelectElection(scanner);
                if (!(controller.electioIsOpen(sessionIdElection))) {
                    System.out.println("Election is not open");
                    continue;
                }
                candidateView.showCandidates(controller);
                String[] vote = { "", "", "" };
                System.out.println("\nVoters:");
                boolean invalidVote = false;
                for (int i = 1; i < vote.length + 1; i++) {
                    System.out.println(
                            "\n No." + i + " Select id candidate: ");
                    String p_vote = scanner.nextLine().trim();

                    boolean duplicate = false;
                    for (int j = 0; j < i - 1; j++) {
                        if (vote[j].equalsIgnoreCase(p_vote)) {
                            duplicate = true;
                            break;
                        }
                    }
                    if (duplicate) {
                        System.out.println("Candidate must be different");
                        invalidVote = true;
                        break;
                    }
                    vote[i - 1] = p_vote;
                }
                if (invalidVote) {
                    continue;
                }
                boolean s = controller.createBallot(sessionIdLogin, vote);
                if (s) {
                    System.out.println("\nBallot:");
                    electionView.showElectionByID(controller, sessionIdElection);
                    voterView.showVoter(controller, sessionIdLogin);
                    System.out.println("vote : ");
                    for (int i = 0; i < vote.length; i++) {
                        System.out.print(" No ." + (i + 1) + vote[i]);
                    }
                    System.out.println();
                }
            } else if (sessionRole == 2) {
                System.out.println("Officer");
                System.out.println("1 Close election  : 2 View Status : 3 Review Pending Group");
                System.out.println("Select Action : ");
                int choice = scanner.nextInt();
                if (choice == 1) {
                    scanner.nextLine();

                    electionView.showElection(controller);
                    String eleString = selectView.SelectElection(scanner);
                    controller.closeElection(eleString);
                    controller.CheckBallot();
                    Map<String, Integer> scores = controller.calculateScore();

                    for (Map.Entry<String, Integer> entry : scores.entrySet()) {
                        System.out.println(
                                entry.getKey() + " = " + entry.getValue() + " point");
                    }
                } else if (choice == 2) {
                    scanner.nextLine();
                    System.out.println("View Status");
                    electionView.showElection(controller);
                    String eleString = selectView.SelectElection(scanner);
                    Election elect = controller.getElectionByID(eleString);
                    List<Ballot> ballot = controller.getBallots();
                    System.out.println("Election Status : " + elect.getStatus());
                    System.out.println("Number of cards received: " + ballot.size());

                } else if (choice == 3) {

                    System.out.println("Review Pending Group");

                    // 1. แสดงกลุ่ม pending
                    // 2. รับว่าผู้ใช้เลือกกลุ่มไหน
                    // 3. รับ decision:
                    // 1 = approve
                    // 2 = reject
                    // 4. ส่งค่าที่เลือกให้ Controller

                }
            }

        }
    }

}