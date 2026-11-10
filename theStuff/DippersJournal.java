package theStuff;

public class DippersJournal extends ThisStuff{
    private String journalTitle;

    public DippersJournal(String stuffId, String publisher, int yearPublished, int totalCopies, int availableCopies, String journalTitle) {
        super(stuffId, publisher, yearPublished, totalCopies, availableCopies);
        this.journalTitle = journalTitle;
    }

    public String getJournalTitle(){return journalTitle;} public void setJournalTitle(String journalTitle){this.journalTitle = journalTitle;}
    
    @Override public int getBorrowDuration() {return 3;}
    @Override public String getDisplayName() {return journalTitle;}
    @Override public String getType() {return "Journal";}

}
