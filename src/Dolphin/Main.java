package Dolphin;

import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        String date = "2016-08-16";
        LocalDate localDate = LocalDate.parse(date);
        Membership membershipTest = new Membership();

        Member memberTest = new Member("Harry", localDate, 17, membershipTest);
        Member memberTest2 = new Member("Elina", localDate, 20, membershipTest);
        memberTest.saveFile();
        memberTest2.saveFile();



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
        Member member = new Member();
        Membership membership = new Membership();
        boolean running = true;
        while (running) {
            menu.viewMenu();
            int userInt = menu.readChoice();
            switch (userInt){
                case 1 -> member.createMember();
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
