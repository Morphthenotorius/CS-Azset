package Homework4;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Participant{
    private String title;
    private List<Lecture> lectures;

    public Professor(String title,String firstName,String lastName,String hogwartsID){
        super(firstName,lastName,hogwartsID);
        lectures = new ArrayList<>();
        this.title = title;
    }
    public void open(Lecture lecture){
        System.out.println("Opened lecture" + lecture.getLectureName());
    }

    public void close(Lecture lecture){
        System.out.println("Closed lecture" + lecture.getLectureName());
    }

    public boolean addLecture(Lecture lecture){
        return lectures.add(lecture);
    }

    @Override
    public String toString() {
        return title + " " + getName();
    }

    @Override
    public boolean attend(Lecture lecture) {
        return lecture.addParticipant(this);
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
