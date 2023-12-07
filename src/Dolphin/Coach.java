package Dolphin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Coach {

    private String name;
    private List<CompetitionSwimmer> swimmers;

    public Coach(String name) {
        this.name = name;
        this.swimmers = new ArrayList<>();
    }
    public Coach(){
    }


    public void addSwimmer( CompetitionSwimmer swimmer) {
        swimmers.add(swimmer);
    }

    public void displaySwimmers() {
        for (CompetitionSwimmer swimmer : swimmers) {
            System.out.println(swimmer.getMember().getName());
        }
    }

    public Coach chooseCoach(Coach coach) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a coach:");
        System.out.println("1. Ben Dover or 2. Shrek?");
        boolean run = true;
        while (run){
            Coach c1 = new Coach("Ben Dover");
            Coach c2 = new Coach("SHrek");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1){
                coach = coach.c1;
                run = false;
                System.out.println("U chose" + coach);
            }else if (choice == 2){
                coach = coach.c2;
                run = false;
                System.out.println("U chose" + coach);
            } else {
                System.out.println("INVALID!");
            }
        }
        return coach;
    }

    public void displayTopFiveSwimmersFromEachDiscipline() {
        for (SwimmingDiscipline discipline : SwimmingDiscipline.values()) {
            List<CompetitionSwimmer> topSwimmers = findTopSwimmers(discipline);
            System.out.println("Top 5 in " + discipline + ":");
            if (!topSwimmers.isEmpty()) {
                for (int i = 0; i < Math.min(topSwimmers.size(), 5); i++) {
                    System.out.println((i + 1) + ". " + topSwimmers.get(i).getMember().getName());
                }
            }else {
                System.out.println("No swimmers available for " + discipline);
            }
            System.out.println();
        }
    }

    private List<CompetitionSwimmer> findTopSwimmers(SwimmingDiscipline discipline) {

        return swimmers;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "name='" + name + '\'' +
                '}';
    }
}