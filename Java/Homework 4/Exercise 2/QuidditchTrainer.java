package Homework4;

import java.util.ArrayList;
import java.util.List;

public class QuidditchTrainer extends Participant {
    private List<Lecture> lectures;
    public QuidditchTrainer(String firstName,String lastName,String hogwartsID){
        super(firstName, lastName, hogwartsID);
        lectures = new ArrayList<>();
    }

    @Override
    public boolean attend(Lecture lecture) {
        return lecture.addParticipant(this);
    }
}
