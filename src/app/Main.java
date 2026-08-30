package app;

import java.util.ArrayList;
import java.util.List;

import controller.ApplicationController;
import model.Ballot;
import model.Candidate;
import model.Election;
import model.Officer;
import model.Voter;

import view.MainView;

public final class Main {
    public static void main(String[] args) {
        List<Ballot> ballots = new ArrayList<>();
        List<Candidate> Candidates = new ArrayList<>();
        List<Election> Elections = new ArrayList<>();
        List<Officer> Officers = new ArrayList<>();
        List<Voter> Voters = new ArrayList<>();

        DataSeeder.seed(ballots, Candidates, Elections, Officers, Voters);

        ApplicationController controller = new ApplicationController(ballots, Candidates, Elections, Officers, Voters);

        MainView view = new MainView(controller);
        view.start();
    }
}
