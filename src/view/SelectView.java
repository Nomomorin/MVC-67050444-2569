package view;
import java.util.Scanner;

public class SelectView {
      public  int SelectRole(Scanner scanner){
            System.out.println("SelectRole");
            System.out.print("\n1: Voter : 2: Officer : 3:Exit ");
            int SelectRole = scanner.nextInt();
            scanner.nextLine();
            return SelectRole;
      }

      public String LoginVoter(Scanner scanner){
            System.out.println("\nLoginVoter");
            System.out.print("\nID: ");
            String LoginVoter =  scanner.nextLine().trim();
            return LoginVoter;
      }

      public String SelectElection(Scanner scanner){
            System.out.println("\nSelectElection");
            System.out.print("\nID: ");
            String SelectElection =  scanner.nextLine().trim();
            return SelectElection;
      }
}
