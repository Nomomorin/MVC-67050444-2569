package app;

import java.util.Arrays;
import java.util.List;

import model.Ballot;
import model.BallotStatus;
import model.Candidate;
import model.Election;
import model.ElectionStatus;
import model.Officer;
import model.Voter;

public final class DataSeeder {

      public static void seed(
                  List<Ballot> Ballots,
                  List<Candidate> Candidates,
                  List<Election> Elections,
                  List<Officer> Officers,
                  List<Voter> Voters) {

            Election e01 = new Election("E01", "การเลือกตั้งประธานชมรมโปร่งใสจริง ๆ นะ", ElectionStatus.OPEN);

            Elections.add(e01);

            Officer o01 = new Officer("O01", "กรรมการผู้ไม่เปิดโพย");
            Officers.add(o01);

            Candidate c01 = new Candidate("C01", "Null Pointer");
            Candidate c02 = new Candidate("C02", "Merge Conflict");
            Candidate c03 = new Candidate("C03", "Works on My Machine");
            Candidate c04 = new Candidate("C04", "404 Policy Not Found");
            Candidate c05 = new Candidate("C05", "Ctrl+Z Nation");

            Candidates.add(c01);
            Candidates.add(c02);
            Candidates.add(c03);
            Candidates.add(c04);
            Candidates.add(c05);

            Voter v01 = new Voter("V01", "โพยอยู่ไหน", true);
            Voter v02 = new Voter("V02", "บังเอิญเหมือนกัน", true);
            Voter v03 = new Voter("V03", "เลือกเองจริง ๆ", true);
            Voter v04 = new Voter("V04", "ใจตรงกันเฉย ๆ", true);
            Voter v05 = new Voter("V05", "ขอดูอีกที", true);
            Voter v06 = new Voter("V06", "บัตรสุดท้าย", true);
            Voter v07 = new Voter("V07", "ไม่ได้อยู่กลุ่มไลน์", true);

            Voters.add(v01);
            Voters.add(v02);
            Voters.add(v03);
            Voters.add(v04);
            Voters.add(v05);
            Voters.add(v06);
            Voters.add(v07);

            String[] ranking_1 = { "C01", "C02", "C03" };
            Ballot b01 = new Ballot("B01", "V01", ranking_1);
            String[] ranking_2 = { "C01", "C02", "C03" };
            Ballot b02 = new Ballot("B02", "V02", ranking_2);
            String[] ranking_3 = { "C02", "C03", "C04" };
            Ballot b03 = new Ballot("B03", "V03", ranking_3);

            add_a(Ballots, b01);
            add_a(Ballots, b02);
            add_a(Ballots, b03);

      }

      public static  void add_a(List<Ballot> Ballots, Ballot ballot) {
            for (int i = 0; i < Ballots.size(); i++) {
                  Ballot CheckBallot = Ballots.get(i);
                  if (Arrays.equals(
                              CheckBallot.getRanking(),
                              ballot.getRanking())) {
                        CheckBallot.setStatus(BallotStatus.PENDING);
                        ballot.setStatus(BallotStatus.PENDING);
                  }
            }
            Ballots.add(ballot);
      }
}