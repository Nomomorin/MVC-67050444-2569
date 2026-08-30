package controller;

import java.util.Map;
import java.util.List;

import model.Ballot;
import model.Candidate;
import model.Election;
import model.Officer;
import model.Voter;

public class ApplicationController {
      private ElectionController electionController;
      private BallotController ballotController;
      private List<Officer> Officers;
      private VoterController voterController;
      private CandidateController candidateController;
      public ApplicationController(
                  List<Ballot> Ballots,
                  List<Candidate> Candidates,
                  List<Election> Elections,
                  List<Officer> Officers,
                  List<Voter> Voters) {
            this.ballotController = new BallotController(Ballots);
            this.candidateController = new CandidateController(Candidates);
            this.electionController = new ElectionController(Elections);
            this.Officers = Officers;
            this.voterController = new VoterController(Voters);
      }

      public List<Voter> getVoter() {
            return voterController.getVoter();
      }

      public List<Candidate> getCandidates(){
            return candidateController.getCandidates();
      }

      public boolean voterIsActive(String id){
            return voterController.isActive(id);
      }

      public List<Election> getElections(){
            return electionController.getElections();
      }

      public List<Ballot> getBallots(){
            return ballotController.getBallots();
      }



      public boolean electioIsOpen(String id){
            return electionController.electioIsOpen(id);
      }

      public Election getElectionByID(String id){
            return electionController.getElectionByID(id);
      }

      public boolean createBallot(String idVoter, String[] ranking){
            return ballotController.createBallot(idVoter, ranking);
      }

      public Voter getVoterByID(String id){
            return voterController.getVoterByID(id);
      }

      public boolean isHaveBallot(String id){
            return ballotController.isHaveBallot(id);
      }


      public void closeElection(String id){
            electionController.closeElection(id);
      }

      public Map<String, Integer> calculateScore() {
            return ballotController.calculateScore();
      }

/*       public List<Job> getOpenJobs() {
            List<Job> openJobs = new ArrayList<>();
            for (Job job : jobs) {
                  if (job.getStatus() == JobStatus.OPEN) {
                        openJobs.add(job);
                  }
            }
            return openJobs;
      }

      public Result<Application> apply(String candidateId, String jobId, LocalDate today) {
            Candidate candidate = findCandidateById(candidateId);
            if (candidate == null) {
                  return Result.fail("Candidate not found");
            }

            Job job = findJobById(jobId);
            if (job == null) {
                  return Result.fail("Job not found");
            }

            if (job.isClosed()) {
                  return Result.fail("Job is closed");
            }

            if (job.isDeadlinePassed(today)) {
                  return Result.fail("Application deadline has passed");
            }

            if (alreadyApplied(candidateId, jobId)) {
                  return Result.fail("Already applied");
            }

            if (!job.isEligible(candidate)) {
                  return Result.fail("Candidate is not eligible for this job");
            }

            String applicationId = String.format("A%03d", applications.size() + 1);
            Application application = new Application(applicationId, candidate, job, today);
            applications.add(application);

            return Result.success("Application successful", application);
      }

      private Candidate findCandidateById(String id) {
            for (Candidate candidate : candidates) {
                  if (candidate.getId().equals(id)) {
                        return candidate;
                  }
            }
            return null;
      }

      private Job findJobById(String id) {
            for (Job job : jobs) {
                  if (job.getId().equals(id)) {
                        return job;
                  }
            }
            return null;
      }

      private boolean alreadyApplied(String candidateId, String jobId) {
            for (Application application : applications) {
                  if (application.getCandidate().getId().equals(candidateId)
                              && application.getJob().getId().equals(jobId)) {
                        return true;
                  }
            }
            return false;
      } */
}