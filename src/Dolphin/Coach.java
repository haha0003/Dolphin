package Dolphin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Coach {

    private String name;
    private List<CompetitionSwimmer> swimmers;
    private List<Coach> coaches = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public Coach(String name) {
        this.name = name;
        this.swimmers = new ArrayList<>();
    }
    public Coach(){
    }

    public void addCoaches(Coach coach){
        coaches.add(coach);
    }

    public void viewCoaches(){
        System.out.println("Coaches: ");
        for (int i = 0; i < coaches.size(); i++){
            System.out.println(i + ". " + coaches.get(i));
        }
    }

    public Coach chooseCoach() {
        boolean run = true;
        Coach selectedCoach = null;

        while (run) {
            viewCoaches();
            System.out.println("Enter the number of the 'desired' coach:");
            int ans = scanner.nextInt();
            scanner.nextLine();

            if (ans > 0 && ans < coaches.size()) {
                selectedCoach = coaches.get(ans);
                System.out.println(selectedCoach);
                run = false;
            } else {
                System.out.println("INVALID!");
            }
        }
        return selectedCoach;
    }


    @Override
    public String toString() {
        return name;
    }



















    public void addSwimmer(CompetitionSwimmer swimmer) {
        swimmers.add(swimmer);
    }

    public void displaySwimmers() {
        for (CompetitionSwimmer swimmer : swimmers) {
            System.out.println(swimmer.getMember().getName());
        }
    }

   /* public Coach chooseCoach(Coach coach) {
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
    */

  /*  public void displayTopFiveSwimmersFromEachDiscipline() {
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
   */

  /*  private List<CompetitionSwimmer> findTopSwimmers(SwimmingDiscipline discipline) {
        return swimmers;
    }
   */

}