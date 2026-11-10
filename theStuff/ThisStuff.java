package theStuff;

public abstract class ThisStuff{

    private String stuffId; private String publisher; private int yearPublished;
    private int totalCopies; private int availableCopies;

    public ThisStuff(String stuffId, String publisher, int yearPublished, int totalCopies, int availableCopies) {
        this.stuffId = stuffId;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        this.totalCopies = totalCopies;
        this.availableCopies = availableCopies;
    }

    public String getStuffId(){return stuffId;} public void setStuffId(String stuffId){this.stuffId = stuffId;}
    public String getPublisher(){return publisher;} public void setPublisher(String publisher){this.publisher = publisher;}
    public int getYearPublished(){return yearPublished;} public void setYearPublished(int yearPublished){this.yearPublished = yearPublished;}
    public int getTotalCopies(){return totalCopies;} public void setTotalCopies(int totalCopies){this.totalCopies = totalCopies;}
    public int getAvailableCopies(){return availableCopies;} public void setAvailableCopies(int availableCopies){this.availableCopies = availableCopies;}

    public abstract int getBorrowDuration();
    public abstract String getDisplayName();
    public abstract String getType();

}
