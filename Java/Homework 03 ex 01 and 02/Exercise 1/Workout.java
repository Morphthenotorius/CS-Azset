import java.util.Date;

public class Workout {
    private Date date;
    private String activityType;
    private int durationMinutes;
    private int caloriesBurned;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setCaloriesBurned(int caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

    public Workout(Date date,int caloriesBurned,int durationMinutes,String activityType){
        this.activityType= activityType;
        this.caloriesBurned = caloriesBurned;
        this.date = date;
        this.durationMinutes = durationMinutes;
    }

    @Override
    public String toString(){
        return "Workout{" +
                "date=" + date +
                ", activityType='" + activityType + '\'' +
                ", durationMinutes=" + durationMinutes +
                ", caloriesBurned=" + caloriesBurned +
                '}';
    }
}
