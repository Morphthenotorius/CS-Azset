public class Goat extends Animal implements Milkable{
    public Goat(String Name) {
        super(Name);
    }

    @Override
    public String messageOnFeed() {
        return getName() + " says Baa!";
    }

    @Override
    public String messageOnMilk() {
        return "Milking " + getName() + "...";
    }
}
