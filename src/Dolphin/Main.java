package Dolphin;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        System.out.println("Welcome!!!");
        Menu menu = new Menu("Please enter number: ", new String[]{
                "1. Create member",
                "2. View member bill// view members",
                "3. View members in arrears",
                "4. Change debt for member",
                "COMPETING SWIMMERS",
                "   5. Register training results",
                "   6. Register competition results",
                "   7. View top 5 swimmers",
                "9. End program"
        });
        Member member = new Member();
        Subscription sub = new Subscription();
        CompetitionResults competitionResults = new CompetitionResults();
        CompetitionSwimmer competitionSwimmer = new CompetitionSwimmer();
        Coach coach = new Coach();
        Coach c1 = new Coach("Ben Dover");
        Coach c2 = new Coach("Shrek Shrekster");
        Coach c3 = new Coach("Stroke maDong");
        coach.addCoaches(c1);
        coach.addCoaches(c2);
        coach.addCoaches(c3);

        TrainingResults trainingResults = new TrainingResults();
        member.readFile(sub, competitionSwimmer);
        boolean running = true;
        while (running) {
            menu.viewMenu();
            int userInt = menu.readChoice();
            switch (userInt){
                case 1 -> member.createMember(sub, competitionSwimmer);
                case 2 -> member.viewMembers();
                case 3 -> coach.chooseCoach();
                case 4 -> member.changeInDebt(member, sub);
                case 5 -> competitionResults.getCompetitionResultsFromUserInput();
                case 6 -> competitionSwimmer.chooseCompSwimmer(member);
                case 7 -> competitionSwimmer.createCompSwimmer(member);
                case 9 -> running = false;
                default -> System.out.println("INVALID!!!");
            }
        }
    }
}
