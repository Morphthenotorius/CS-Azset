import java.util.ArrayList;
import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private String studentId;
    private String subject1;
    private String subject2;

    private double subject1Grade;
    private double subject2Grade;


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setSubject1(String subject1) {
        this.subject1 = subject1;
    }

    public void setSubject2(String subject2) {
        this.subject2 = subject2;
    }

    public void setSubject1Grade(double subject1Grade) {
        this.subject1Grade = subject1Grade;
    }

    public void setSubject2Grade(double subject2Grade) {
        this.subject2Grade = subject2Grade;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getStudentId(){
        return studentId;
    }

    public String getSubject1(){
        return subject1;
    }

    public String getSubject2(){
        return subject2;
    }

    public double getSubject1Grade(){
        return subject1Grade;
    }

    public double getSubject2Grade() {
        return subject2Grade;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    private double average;

    public Student(String firstName,String lastName,String studentId,String subject1,String subject2){
            this.firstName = firstName;
            this.lastName = lastName;
            this.studentId = studentId;
            this.subject1 = subject1;
            this.subject2 = subject2;
            this.subject1Grade = 0.0;
            this.subject2Grade = 0.0;
            this.average = 0.0;
    }

    public void updateGrade(String subject, double newGrade){
        if(subject.toUpperCase().equals(subject1.toUpperCase())){
            subject1Grade = newGrade;
        }

        else if (subject.toLowerCase().equals(subject2.toLowerCase())){
            subject2Grade = newGrade;
        }

        else{
            System.out.println("Invalid Subject!");
        }
    }

    public void calculateAverage(){
        average = (subject1Grade + subject2Grade)/ 2.0;
    }

    public void honorStudentMessage(){
        if (average < 1.5){
            System.out.println("Excellent performance, honor student!");
        }

        else{
            System.out.println("Keep working hard!");
        }
    }

    @Override 
    public String toString(){
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studentID='" + studentId + '\'' +
                ", subject1='" + subject1 + '\'' +
                ", subject2='" + subject2 + '\'' +
                ", subject1Grade=" + subject1Grade +
                ", subject2Grade=" + subject2Grade +
                ", average=" + average +
                '}';
    } 
}
