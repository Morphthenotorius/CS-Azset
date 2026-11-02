import java.util.*;

public class fitnesLog {
    private List<Workout> workouts;
    private Queue<Workout> workoutPlan;
    private Stack<Workout> historyStack;

    public fitnesLog(){
        workouts = new ArrayList<>();
        workoutPlan = new LinkedList<>();
        historyStack = new Stack<>();
    }

    public fitnesLog(List<Workout> workouts, Queue<Workout> workoutPlan, Stack<Workout> historyStack){
        this.historyStack = historyStack;
        this.workoutPlan = workoutPlan;
        this.workouts = workouts;
    }

    public Stack<Workout> getHistoryStack() {
        return historyStack;
    }

    public void setHistoryStack(Stack<Workout> historyStack) {
        this.historyStack = historyStack;
    }

    public Queue<Workout> getWorkoutPlan() {
        return workoutPlan;
    }

    public void setWorkoutPlan(Queue<Workout> workoutPlan) {
        this.workoutPlan = workoutPlan;
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<Workout> workouts) {
        this.workouts = workouts;
    }

    public void logWorkout(Workout workout){
        workouts.add(workout);
        historyStack.push(workout);
    }

    public Workout undoLastLog(){
        if(historyStack.isEmpty()){
            return null;
        }

        return historyStack.pop();
    }

    public void addPlannedWorkout(Workout workout){
        workoutPlan.add(workout);
    }

    public Workout completeNextPlannedWorkout(){
       Workout completed = workoutPlan.poll();
       if(completed == null){
           System.out.println("No workout was found");
       }
       logWorkout(completed);
       return completed;
    }

    public List<Workout> findWorkoutsByDate(Date date){
        List<Workout> workoutList = new ArrayList<>();
        for (Workout w : workouts){
            if(w.getDate().equals(date)){
                workoutList.add(w);
            }
        }
        return workoutList;
    }

    public double calculateCalories(){
        double total = 0;
        for(Workout w : workouts){
            total+= w.getCaloriesBurned();
        }
        return total;
    }

    public void purgeWorkoutsBelowCalories(double limit){
            workouts.removeIf(w -> w.getCaloriesBurned()<limit);
    }
}

