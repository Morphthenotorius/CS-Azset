public abstract class Animal {
    private String Name;
    public abstract String messageOnFeed();

    public Animal(String Name){
        this.Name = Name;
    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
