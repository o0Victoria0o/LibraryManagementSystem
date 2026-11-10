package theStuff;

public class RandomBook extends ThisStuff{
    private String randomTitle;
    private String randomAuthor;

    public RandomBook(String stuffId, String publisher, int yearPublished, int totalCopies, int availableCopies, String randomTitle, String randomAuthor) {
        super(stuffId, publisher, yearPublished, totalCopies, availableCopies);
        this.randomTitle = randomTitle;
        this.randomAuthor = randomAuthor;
    }

    public String getRandomTitle(){return randomTitle;} public void setRandomTitle(String randomTitle){this.randomTitle = randomTitle;}
    public String getRandomAuthor(){return randomAuthor;} public void setRandomAuthor(String randomAuthor){this.randomAuthor = randomAuthor;}

    @Override public int getBorrowDuration() {return 7;}
    @Override public String getDisplayName() {return title;}
    @Override public String getType() {return "Book";}
}
