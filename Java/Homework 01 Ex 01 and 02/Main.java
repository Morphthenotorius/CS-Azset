import java.util.ArrayList;
import java.util.List;
public class Main{
    public static void main(String [] args){
        Student student = new Student("Mahammad","Gurbanov","250150017","Fundamentals of Programming","Discrete Structures");
        student.updateGrade("Fundamentals of Programming", 1.5);
        student.updateGrade("Discrete Structures", 1.4);
        student.updateGrade("Chemistry", 1.3);

        student.calculateAverage();
        student.honorStudentMessage();

        System.out.println(student.toString());
    }
}