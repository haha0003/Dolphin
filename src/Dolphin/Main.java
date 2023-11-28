package Dolphin;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        System.out.println("Welcome!!!");
        Menu menu = new Menu("Please enter number: ", new String[]{
                "1. Create member",
                "2. View member bill",
                "3. View members in arrears",
                "COMPETING SWIMMERS",
                "   4. Register training results",
                "   5. Register competition results",
                "   6. View top 5 swimmers",
                "9. End program"
        });
        // member.readFile();
        boolean running = true;
        while (running) {
            menu.viewMenu();
            int userInt = menu.readChoice();
            switch (userInt){
                case 1 -> System.out.println();
                case 2 -> System.out.println();
                case 3 -> System.out.println();
                case 4 -> System.out.println();
                case 5 -> System.out.println();
                case 6 -> System.out.println();
                case 9 -> running = false;
                default -> System.out.println("INVALID!!!");
            }
        }
    }



}
}
