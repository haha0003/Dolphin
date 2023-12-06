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
                "4. Change debt for member"
                "COMPETING SWIMMERS",
                "   5. Register training results",
                "   6. Register competition results",
                "   7. View top 5 swimmers",
                "9. End program"
        });
        Member member = new Member();
        Subscription sub = new Subscription();
        member.readFile(sub);
        boolean running = true;
        while (running) {
            menu.viewMenu();
            int userInt = menu.readChoice();
            switch (userInt){
                case 1 -> member.createMember(sub);
                case 2 -> member.viewMembers();
                case 3 -> sub.displayDebtList();
                case 4 -> member.changeInDebt(member, sub);
                case 5 -> System.out.println();
                case 6 -> System.out.println();
                case 7 -> System.out.println();
                case 9 -> running = false;
                default -> System.out.println("INVALID!!!");
            }
        }
    }
}
