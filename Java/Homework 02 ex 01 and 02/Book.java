public class Book {
    private int id;
    private String title;
    private String coverImgUrl;
    private int pageNums;
    private String author;

    public Book(int id,String title, String coverImgUrl,String author,int pageNums){
        this.id = id;
        this.title = title;
        this.coverImgUrl = coverImgUrl;
        this.pageNums = pageNums;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCoverImgUrl() {
        return coverImgUrl;
    }
    public void setCoverImgUrl(String coverImgUrl) {
        this.coverImgUrl = coverImgUrl;
    }
    public int getPageNums() {
        return pageNums;
    }
    public void setPageNums(int pageNums) {
        this.pageNums = pageNums;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
}
