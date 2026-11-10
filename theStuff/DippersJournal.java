package theStuff;

public class DippersJournal extends ThisStuff{
    private String journalName;

    public DippersJournal(String stuffId, String publisher, int yearPublished, int totalCopies, int availableCopies, String journalName) {
        super(stuffId, publisher, yearPublished, totalCopies, availableCopies);
        this.journalName = journalName;
    }

    public String getJournalName(){return journalName;} public void setJournalName(String journalName){this.journalName = journalName;}
    
    @Override public int getBorrowDuration() {return 3;}
    @Override public String getDisplayName() {return journalName;}
    @Override public String getType() {return "Journal";}

}
