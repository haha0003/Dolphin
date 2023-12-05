package Dolphin;

import java.util.ArrayList;

public class competitionSwimmer extends Member {

// using private access modifiers for fields
// and providing public getter and setter methods
    private TrainingResults trainingResults;
    private String trainer;
    private SwimmingDiscipline swimmingDiscipline;

    public competitionSwimmer(Member member, SwimmingDiscipline swimmingDiscipline, String trainer, TrainingResults trainingResults) {
        super(member.getName(), member.getBirthday(), member.getAge(), member.getMembership());
        this.swimmingDiscipline = swimmingDiscipline;
        this.trainer = trainer;
        this.trainingResults = trainingResults;
    }

    public SwimmingDiscipline getSwimmingDiscipline() {
        return swimmingDiscipline;
    }

    public void setSwimmingDiscipline(SwimmingDiscipline swimmingDiscipline) {
        this.swimmingDiscipline = swimmingDiscipline;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }





}
