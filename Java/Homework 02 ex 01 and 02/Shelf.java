public class Shelf {
    private int id;
    private String name;
    private Section section; 
    private Book [] books = new Book[15];

    public Shelf(int id, String name){
        this.id = id;
        this.name = name;
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

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public boolean addBook(Book book){
        for (int i = 0; i<15; i++){
            if(books[i] == null){
                books[i] = book;                   
                return true;
            }
        }
        return false;
    }

    public void sortByTitle(){
        for(int i =0; i<15;i++){
            for(int j=0; j<books.length-1-i;j++){
                if(books[j].getTitle() != null && books[j+1].getTitle()!= null && books[j].getTitle().compareTo(books[j+1].getTitle())>0){
                    var x = books[j];
                    books[j] = books[j+1];
                    books[j+1] = x;
                }
            }
        }
        
    }

    public boolean isUtilized(){
        for (Book book : books) {
            if(book != null){
                return true;
            }
        }
        return false;
    }
}
