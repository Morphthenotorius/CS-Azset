public class Cow extends Animal implements Rideable,Milkable{
    public Cow(String Name) {
        super(Name);
    }

    @Override
    public String messageOnFeed() {
        return getName() + " says Moo!";
    }

    @Override
    public String messageOnMilk() {
        return "Milking " + getName() + "...";
    }

    @Override
    public String messageOnRide() {
        return "Riding " + getName() + "!";
    }
}
