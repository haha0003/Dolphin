package Dolphin;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompetitionResults extends Member {

    private double result;
    private LocalDateTime date;
    private CompetitionSwimmer competitionSwimmer;
    private Coach coach;
    private List<CompetitionResults> competitionResultsList;



    public CompetitionResults(double result, LocalDateTime date, CompetitionSwimmer competitionSwimmer, Coach coach) {
        this.result = result;
        this.date = date;
        this.competitionSwimmer = competitionSwimmer;
        this.coach = coach;
        this.competitionResultsList = new ArrayList<>();
        competitionSwimmer.addCompetitionResults(this);
    }

    public CompetitionResults(){

    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<CompetitionResults> getCompetitionResultsList() {
        return competitionResultsList;
    }


    public LocalDateTime getDate() {
        return date;
    }

    public Coach getCoach() {
        return coach;
    }


    public CompetitionSwimmer getCompetitionSwimmer() {
        return competitionSwimmer;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public void getCompetitionResultsFromUserInput() {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter competition results: ");
        this.result = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Enter competition date (yyyy-MM-dd HH:mm): ");
        String dateString = scanner.nextLine();
        this.date = LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));



        this.competitionResultsList.add(this);

        saveCompetitionResultsToFile();

    }

    public void saveCompetitionResultsToFile() {
        try {
            PrintWriter writer = new PrintWriter("CompetitionResults.txt");

            for (CompetitionResults competitionResults : this.competitionResultsList) {
                writer.println("Competition Swimmer: " + competitionResults.getCompetitionSwimmer());
                writer.println("Results: " + competitionResults.getResult());
                writer.println("Date: " + competitionResults.getDate());
                writer.println();
            }
        System.out.println("Competition results saves successfully!");
        writer.close();
    } catch(FileNotFoundException e) {
       // throw new RuntimeException(e);
            System.err.println("Error saving competition results to file: " + e.getMessage());
    }

    }


    @Override
    public String toString() {
        return "CompetitionResults{" +
                ", competition Swimmer=" + competitionSwimmer +
                ", coach=" + coach +
                "result=" + result +
                ", date=" + date +
               '}';
    }
}
