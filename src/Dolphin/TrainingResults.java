package Dolphin;

public class TrainingResults extends Member {

    private Competition competition;
    private int place;
    private double timeSeconds;

    public TrainingResults(Competition competition, int place, double timeSeconds) {

        this.competition = competition;
        this.place = place;
        this.timeSeconds = timeSeconds;
    }

    public Competition getCompetition() {
        return competition;
    }

    public double getTimeSeconds() {
        return timeSeconds;
    }

    public int getPlace() {
        return place;
    }
}
