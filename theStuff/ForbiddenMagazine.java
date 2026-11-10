package theStuff;

public class ForbiddenMagazine extends ThisStuff {
    private String magazineIssue;

    public ForbiddenMagazine(String stuffId, String publisher, int yearPublished, int totalCopies, int availableCopies, String magazineIssue) {
        super(stuffId, publisher, yearPublished, totalCopies, availableCopies);
        this.magazineIssue = magazineIssue;
    }
   
    public String getMagazineIssue(){return magazineIssue;} 
    public void setMagazineIssue(String magazineIssue){this.magazineIssue = magazineIssue;}

    @Override public int getBorrowDuration() {return 0;}
    @Override public String getDisplayName() {return magazineIssue;}
    @Override public String getType() {return "Magazine";}

}
