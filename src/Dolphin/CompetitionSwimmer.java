package Dolphin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompetitionSwimmer extends Member{

    private Member member;
    private List<TrainingResults> trainingResultsList;
    private Coach coach;



    private SwimmingDiscipline swimmingDiscipline;
    private List<CompetitionResults> competitionResultsList;
    private List<Member> competitionSwimmers = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public CompetitionSwimmer(Member member, SwimmingDiscipline swimmingDiscipline, Coach coach, TrainingResults trainingResults) {
        this.member = member;
        this.swimmingDiscipline = swimmingDiscipline;
        this.coach = coach;
        this.trainingResultsList = new ArrayList<>();
        this.competitionResultsList = new ArrayList<>();
    }

    public CompetitionSwimmer(){
    }

    public void setSwimmingDiscipline(SwimmingDiscipline swimmingDiscipline) {
        this.swimmingDiscipline = swimmingDiscipline;
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

    public void findAddCompSwimmer(Member member) {
        SwimmerDiscipline swimmerType = member.getMembership().getSwimmerType();
        if (swimmerType == SwimmerDiscipline.COMPETITOR) {
            competitionSwimmers.add(member);
        }
    }

    public void viewCompSwimmers() {
        for (int i = 0; i<competitionSwimmers.size(); i++){
            System.out.println(i + ". " + competitionSwimmers.get(i));
        }
    }

    public void chooseCompSwimmer(Member member) {
        viewCompSwimmers();
        System.out.println("Choose Number");
        int choice = scanner.nextInt();
        scanner.nextLine();
        member = competitionSwimmers.get(choice);
        System.out.println("You picked: " + member);
    }

    public void addToCompList(Member member) {
        competitionSwimmers.add(member);
    }

    public void createCompSwimmer(Member member, Coach coach, TrainingResults trainingResults) {
        chooseCompSwimmer(member);
        findSwimmerDiscipline();
        coach.chooseCoach(coach);


        //CompetitionSwimmer competitionSwimmer = new CompetitionSwimmer(member, getSwimmingDiscipline() )

    }



    public void findSwimmerDiscipline() {
        boolean run = true;
        while (run){
            System.out.println("Enter number of swimmer discipline:");
            SwimmingDiscipline[] s = SwimmingDiscipline.values();
            for (int i = 0; i < s.length; i++){
                System.out.println(i + ". " + s[i]);
            }
            int ans = scanner.nextInt();
            scanner.nextLine();
            if (ans < s.length && ans == 0){
                setSwimmingDiscipline(SwimmingDiscipline.CRAWL);
                System.out.println("Swimmer discipline: " + getSwimmingDiscipline());
                run = false;
            } else if (ans < s.length && ans == 1) {
                setSwimmingDiscipline(SwimmingDiscipline.MEDLEY);
                System.out.println("Swimmer discipline:" + getSwimmingDiscipline());
                run = false;
            }else if(ans < s.length && ans == 2){
                setSwimmingDiscipline(SwimmingDiscipline.BACKSTROKE);
                System.out.println("Swimmer discipline:" + getSwimmingDiscipline());
                run = false;
            }else if(ans < s.length && ans == 3){
                setSwimmingDiscipline(SwimmingDiscipline.BREASTSTROKE);
                System.out.println("Swimmer discipline:" + getSwimmingDiscipline());
                run = false;
            }else if(ans < s.length && ans == 4){
                setSwimmingDiscipline(SwimmingDiscipline.FREESTYLE);
                System.out.println("Swimmer discipline:" + getSwimmingDiscipline());
                run = false;
            } else {
                System.out.println("INVALID!!!");
            }
        }
    }


}
