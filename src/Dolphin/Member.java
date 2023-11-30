package Dolphin;

import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;

public class Member {
    private String name;
    private LocalDate birthday;
    private int age;
    private Membership membership;
    private ArrayList<Member> members = new ArrayList<>();
    final String filename = "MembersList.csv";
    private boolean inDebt;

    public static final String RED = "\u001B[31m";
    public static final String COLOR_RESET = "\u001B[0m";

    Scanner scanner = new Scanner(System.in);

    Member(String name, LocalDate birthday,int age, Membership membership, boolean inDebt){
        this.name = name;
        this.birthday = birthday;
        this.membership = membership;
        this.age = age;
        this.inDebt = inDebt;
    }

    Member(){
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public Membership getMembership() {
        return membership;
    }
    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    public boolean isInDebt() {
        return inDebt;
    }
    public void setInDebt(boolean inDebt) {
        this.inDebt = inDebt;
    }

    public void findName(){
        boolean run = true;
        while (run) {
            System.out.println("Enter first and last name: ");
            String name = scanner.nextLine();
            String[] n = name.split(" ");
            if (n.length == 2) {
                String firstName = n[0];
                String lastName = n[1];
                setName(name);
                System.out.println("Name: " + getName());
                run = false;
            } else {
                System.out.println("INVALID!!!");
            }
        }
    }

    public void findBirthday(){
        LocalDate today = LocalDate.now();
        System.out.println("Enter year of birth");
        int yearOfBirth = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter month of birth");
        int monthOfBirth = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter date of birth");
        int dateOfBirth = scanner.nextInt();
        scanner.nextLine();

            birthday = LocalDate.of(yearOfBirth, monthOfBirth, dateOfBirth);
            setBirthday(birthday);
            Period p = Period.between(birthday, today);
            age = p.getYears();
            setAge(age);
            System.out.println(getBirthday());
            System.out.println("Age: " + getAge());
    }

    public void createMember(Subscription sub){
        findName();
        findBirthday();
        Membership membership = new Membership();
        membership.createMembership(getAge());
        setMembership(membership);
        setInDebt(true);
        Member m = new Member(getName(),getBirthday(), getAge(), getMembership(),isInDebt());
        members.add(m);
        saveFile(m);
        System.out.println(m);
        sub.addToDebtList(m);
    }

    public void viewMembers(){
        System.out.println("VIEW MEMBERS");
        for (int i = 0; i < members.size(); i++){
            System.out.println(i + ". " + members.get(i));
        }
    }

    public void saveFile(Member member){
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(filename,true));
            pw.println(member.getName() + "," + member.getBirthday() + "," + member.getAge() + "," +
                    member.membership.getMemberStatus()+ "," + member.membership.getMemberType() + "," +
                    member.membership.getSwimmerType() + "," + member.isInDebt());
            pw.close();
            System.out.println("SAVED FILE");
        } catch (IOException e){
            System.out.println("ERROR!!!");
            e.printStackTrace();
        }
    }

    public void readFile() {
        try {
            File file = new File(filename);
            if (!file.exists()) {
                System.out.println("File does not exist.");
                return; }
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] tokens = line.split(",");
                if (tokens.length >= 6) {
                    String name = tokens[0];
                    LocalDate birthday = LocalDate.parse(tokens[1]);
                    int age = Integer.parseInt(tokens[2]);
                    MemberStatus memberStatus = MemberStatus.valueOf(tokens[3]);
                    MemberType memberType = MemberType.valueOf(tokens[4]);
                    SwimmerType swimmerType = SwimmerType.valueOf(tokens[5]);
                    boolean inDebt = Boolean.parseBoolean(tokens[6]);
                    Member newMember = new Member(name, birthday, age,
                            new Membership(memberStatus, memberType, swimmerType), inDebt);
                    members.add(newMember);
                }
            }
        } catch (IOException e) {
            System.out.println("ERROR!!!");
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return  "--------------------------------" +
                "\nName: " + name +
                "\nBirthday: " + birthday +
                ", age: " + age + "\n" + membership + "\n" +
                "\nIs in debt?: " + RED  + inDebt + COLOR_RESET;
    }


}
