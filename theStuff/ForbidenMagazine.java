package theStuff;

public class ForbidenMagazine extends ThisStuff {
    private String magazineName;

    public ForbidenMagazine(String stuffId, String publisher, int yearPublished, int totalCopies, int availableCopies, String magazineName) {
        super(stuffId, publisher, yearPublished, totalCopies, availableCopies);
        this.magazineName = magazineName;
    }
   
    public String getMagazineName(){return magazineName;} 
    public void setMagazineName(String magazineName){this.magazineName = magazineName;}

    @Override public int getBorrowDuration() {return 0;}
    @Override public String getDisplayName() {return magazineName;}
    @Override public String getType() {return "Magazine";}

}
