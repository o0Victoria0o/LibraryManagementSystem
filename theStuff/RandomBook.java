package theStuff;

public class RandomBook extends ThisStuff{
    private String title;
    private String author;

    public RandomBook(String stuffId, String publisher, int yearPublished, int totalCopies, int availableCopies, String title, String author) {
        super(stuffId, publisher, yearPublished, totalCopies, availableCopies);
        this.title = title;
        this.author = author;
    }

    public String getTitle(){return title;} public void setTitle(String title){this.title = title;}
    public String getAuthor(){return author;} public void setAuthor(String author){this.author = author;}

    @Override public int getBorrowDuration() {return 7;}
    @Override public String getDisplayName() {return title;}
    @Override public String getType() {return "Book";}
}
