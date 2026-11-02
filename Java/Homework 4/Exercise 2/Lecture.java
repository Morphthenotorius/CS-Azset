package Homework4;

import java.util.ArrayList;
import java.util.List;

public class Lecture {
    private String lectureID;
    private String lectureName;
    private List<Participant> participants;
    private Professor professor;

    public Lecture(String lectureID,String lectureName ) {
        this.participants = new ArrayList<>();
        this.lectureID = lectureID;
        this.lectureName = lectureName;
    }

    public boolean addParticipant(Participant participant){
        if(participants.contains(participant)){
            return false;
        }

        if(participant instanceof Professor){
            if (this.professor != null){
                return false;
            }
            this.professor = (Professor) participant;
        }

        else if(!(participant instanceof Professor || participant instanceof Apprentice || participant instanceof QuidditchTrainer)){
            return false;
        }
       return participants.add(participant);

    }

    public void takePlace(){
        if (professor != null){
            professor.open(this);
            for(var participant : participants){
                if(participant instanceof Apprentice){
                    System.out.println(participant.getName() + "is present");
                }
            }

            professor.close(this);
        }


    }

    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public String getLectureID() {
        return lectureID;
    }

    public void setLectureID(String lectureID) {
        this.lectureID = lectureID;
    }
}
