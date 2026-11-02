package Homework4;

public abstract class Participant {
    protected String firstName;
    protected String lastName;
    protected String hogwartsID;

    public Participant(String firstName,String lastName,String hogwartsID){
        this.firstName = firstName;
        this.lastName = lastName;
        this.hogwartsID = hogwartsID;
    }
    public String getName(){
        return firstName + " " + lastName;
    }

    public String getHogwartsID(){
        return hogwartsID;
    }

    public abstract boolean attend(Lecture lecture);
}
