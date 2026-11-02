import java.util.ArrayList;
import java.util.List;

public class Farm {
    private List<Animal> animals;
    public Farm(){
        animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal){
        animals.add(animal);
    }

    public void feedAllAnimals(){
        for(var animal : animals){
            System.out.println(animal.messageOnFeed());
        }
    }

    public String singFarmSongVerse(Animal animal){
        StringBuilder verse = new StringBuilder();
        verse.append(animal.messageOnFeed()).append("\n");

        if(animal instanceof Milkable){
            verse.append(((Milkable) animal).messageOnMilk()).append("\n");
        }

        if(animal instanceof Rideable){
            verse.append(((Rideable) animal).messageOnRide()).append("\n");
        }

        return verse.toString();
    }

    public String singFarmSong(){
        StringBuilder song = new StringBuilder();
        for(var animal : animals){
            song.append(singFarmSongVerse(animal));
        }

        return song.toString();
    }
}
