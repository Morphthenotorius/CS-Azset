package Homework4;

import java.util.ArrayList;
import java.util.List;

public class Apprentice extends Participant{
    private final List<Lecture> lectures;
    public Apprentice(String firstName, String lastName, String hogwartsID) {
        super(firstName, lastName, hogwartsID);
        lectures = new ArrayList<>();
    }

    @Override
    public boolean attend(Lecture lecture) {
        return lecture.addParticipant(this);
    }
}
