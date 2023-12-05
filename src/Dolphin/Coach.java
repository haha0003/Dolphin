package Dolphin;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private String name;
    private List<CompetitionSwimmer> swimmers;


    public Coach(String name) {
        this.name = name;
        this.swimmers = new ArrayList<>();
    }


    public void addSwimmer( CompetitionSwimmer swimmer) {
        swimmers.add(swimmer);
    }

    public void displaySwimmers() {
        for (CompetitionSwimmer swimmer : swimmers) {
            System.out.println(swimmer.getMember().getName());
        }
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
}
