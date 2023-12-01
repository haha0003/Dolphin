package Dolphin;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Member {
    private String name;
    private LocalDate birthday;
    private int age;
    private Membership membership;
    private ArrayList<Member> members = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    Member(String name, LocalDate birthday,int age, Membership membership){
        this.name = name;
        this.birthday = birthday;
        this.membership = membership;
        this.age = age;
    }


    Member(){
    }


    public void saveFile(){

        try{
            FileWriter wr = new FileWriter("file.txt",true);
            wr.write(this.toString());
            wr.flush();
            wr.write(System.getProperty("line.separator"));

        }
        catch (Exception ex){
            System.out.println("Error");
        }

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

    public void findName(){
        System.out.println("Enter first and last name: ");
        String name = scanner.nextLine();
        String[] n = name.split(" ");
        if (n.length == 2){
            String firstName = n[0];
            String lastName = n[1];
            setName(name);
            System.out.println("Name: " + getName());
        } else {
            System.out.println("INVALID!!!");
        }
    }  /* findName and findBirthday - shall we make these methods
    private since they are used internally within the createMember method?*/

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

    public void createMember(){
        findName();
        findBirthday();
        Membership membership = new Membership();
        membership.createMembership(getAge());
        setMembership(membership);
        Member m = new Member(getName(),getBirthday(), getAge(), getMembership());
        members.add(m);
        System.out.println(m);
    }

    @Override
    public String toString() {
        return  "--------------------------------" +
                "\nNEW MEMBER " +
                "\nName: " + name +
                "\nBirthday: " + birthday +
                ", age: " + age + "\n" + membership;
    }
}
