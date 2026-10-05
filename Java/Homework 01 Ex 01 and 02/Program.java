import java.util.ArrayList;
import java.util.List;

public class Program {
    private String title;
    private int credits;
    private String courseLanguage;
    private String location;

    public Program(String title,int credits,String courseLanguage,String location){
        this.title = title;
        this.credits = credits;
        this.courseLanguage = courseLanguage;
        this.location = location;
    }

    public String getTitle(){
        return title;
    }

    public int getCredits(){
        return credits;
    }

    public String getCourseLanguage(){
        return courseLanguage;
    }

    public String getLocation(){
        return location;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setCredits(int credits){
        this.credits = credits;
    }

    public void setCourseLanguage(String courseLanguage){
        this.courseLanguage = courseLanguage;
    }

    public void setLocation(String location){
        this.location = location;
    }

    @Override 
    public String toString(){

        //I just wanted to write toString() in JSON format)

        return "{" +
            "\"title\":\"" + title + "\"," +
            "\"credits\":" + credits + "," +
            "\"courseLanguage\":\"" + courseLanguage + "\"," +
            "\"location\":\"" + location + "\"" +
            "}";


    }

    public String getDisplayName(){
        return title + "(at Campus " + location + ")";
    }
}
