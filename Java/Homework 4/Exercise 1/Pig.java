public class Pig extends Animal implements Rideable{
    public Pig(String Name) {
        super(Name);
    }

    @Override
    public String messageOnFeed() {
        return getName() + " says Oink!";
    }

    @Override
    public String messageOnRide() {
        return "Riding " + getName() + "!";
    }
}
