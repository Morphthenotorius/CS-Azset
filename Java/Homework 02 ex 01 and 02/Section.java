import java.util.Arrays;

public class Section {
        private int id;
        private String name;
        private Shelf [] shelves = new Shelf[5];

        public Section(int id,String name){
            this.name=name;
            this.id = id;
        }

        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
           this.name = name;
        }

        public Shelf[] getShelves() {
            return shelves;
        }
        public void setShelves(Shelf[] shelves) {
            this.shelves = shelves;
        }

        public void addToShelf(Book book,int shelfId,String shelfName){
            for (int i = 0; i<shelves.length;i++) {
                if(shelves[i]!=null){
                    if(shelves[i].addBook(book)){
                        return;
                    }
                }

                else{
                    Shelf newShelf = new Shelf(shelfId,shelfName);
                    newShelf.addBook(book);
                    shelves[i] = newShelf;
                    return;
                }
            }
        }

        public void sortSection(){
            for (int i = 0; i < shelves.length; i++) {
            if (shelves[i] != null) {
                shelves[i].sortByTitle();
            }
        }
    }
}
