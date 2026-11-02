public class Tramway {
    private int id;
    private int amountOfWagons;
    private String driverName;

    public Tramway(int x,int amountOfWagons,String driverName){
        this.amountOfWagons = amountOfWagons;
        this.driverName = driverName;
        id = 700000+x;
    }
    public int getId(){
        return id;
    }

    public int getAmountOfWagons() {
        return amountOfWagons;
    }

    public void setAmountOfWagons(int amountOfWagons) {
        this.amountOfWagons = amountOfWagons;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
}
