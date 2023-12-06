package Dolphin;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompetitionSwimmer {

    private Member member;
    private List<TrainingResults> trainingResultsList;
    private Coach coach;
    private SwimmingDiscipline swimmingDiscipline;
    private List<CompetitionResults> competitionResultsList;

    public CompetitionSwimmer(Member member, SwimmingDiscipline swimmingDiscipline, Coach coach, TrainingResults trainingResults) {

        this.member = member;
        this.swimmingDiscipline = swimmingDiscipline;
        this.coach = coach;
        this.trainingResultsList = new ArrayList<>();
        this.competitionResultsList = new ArrayList<>();

    }



    public CompetitionSwimmer(){

    }


    public Member getMember() {
        return member;
    }

    public Coach getCoach() {
        return coach;
    }

    public SwimmingDiscipline getSwimmingDiscipline() {
        return swimmingDiscipline;
    }

    public List<TrainingResults> getTrainingResults() {
        return trainingResultsList;
    }

    public List<CompetitionResults> getCompetitionResultsList() {
        return competitionResultsList;
    }


    public void addCompetitionResults(CompetitionResults competitionResults) {
        competitionResultsList.add(competitionResults);
    }

    public void addTrainingResults(TrainingResults trainingResults) {
        trainingResultsList.add(trainingResults);
    }

    public static CompetitionSwimmer createCompetitionSwimmer() {
        Scanner scanner = new Scanner(System.in);

        //den indtastede member information skal kunne tilknyttes membership-klassen
        System.out.println("Enter member information: ");


        Member member = new Member();
        member.createMember();

        System.out.println("Enter swimming discipline: ");
        System.out.println("0. " + SwimmingDiscipline.CRAWL);
        System.out.println("1. " + SwimmingDiscipline.MEDLEY);
        System.out.println("2. " + SwimmingDiscipline.BACKSTROKE);
        System.out.println("3. " + SwimmingDiscipline.BREASTSTROKE);
        System.out.println("4. " + SwimmingDiscipline.FREESTYLE);

        int disciplineChoice = scanner.nextInt();
        SwimmingDiscipline swimmingDiscipline = SwimmingDiscipline.values()[disciplineChoice];


        CompetitionSwimmer newSwimmer = new CompetitionSwimmer(member, swimmingDiscipline, new Coach(""), new TrainingResults(0.0, LocalDateTime.now()));

        newSwimmer.addTrainingResults(new TrainingResults(0.0, LocalDateTime.now()));
        newSwimmer.addCompetitionResults(new CompetitionResults());

        return newSwimmer;
    }

}
