import java.util.ArrayList;
import java.util.List;

public class StubTrack {
    private int capacity;
    private int amountOfTramways;
    private List<Tramway> stack;
    public StubTrack(int capacity){
        this.capacity = capacity;
        stack = new ArrayList<>();
        this.amountOfTramways = 0;
    }

    public boolean push(Tramway tramway){
        if(amountOfTramways>=capacity){
            return false;
        }

        stack.add(tramway);
        amountOfTramways++;
        return true;
    }

    public Tramway pop(){
        if(amountOfTramways==0){
            return null;
        }
        Tramway t = stack.remove(stack.size()-1);
        amountOfTramways--;
        return t;
    }

    public int amountOfFreeSpots(){
        return capacity - amountOfTramways;
    }

    public Tramway find(int id){
       for(Tramway t : stack){
           if(t.getId() == id){
               return t;
           }
       }
       return null;
    }

    public boolean remove(int id){
        Tramway t = find(id);
        if(t != null){
            stack.remove(t);
            amountOfTramways--;
            return true;
        }
        return false;
    }


}
