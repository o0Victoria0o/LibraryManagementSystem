package dealsHere;

import java.time.LocalDate;
import theGuy.ThisGuy;
import theStuff.ThisStuff;

public class TheDeal {
    private ThisGuy guy;
    private ThisStuff stuff;
    private LocalDate dateBorrowed;
    private LocalDate dueDate;
    private LocalDate dateReturned;

    public TheDeal(ThisGuy guy, ThisStuff stuff) {
        this.guy = guy;
        this.stuff = stuff;
        this.dateBorrowed = LocalDate.now();
        this.dueDate = this.dateBorrowed.plusDays(stuff.getBorrowDuration());
        this.dateReturned = null;
    }


    //Loads from file here ->
    public TheDeal(ThisGuy guy, ThisStuff stuff, LocalDate dateBorrowed, LocalDate dueDate, LocalDate dateReturned) {
        this.guy = guy;
        this.stuff = stuff;
        this.dateBorrowed = dateBorrowed;
        this.dueDate = dueDate;
        this.dateReturned = dateReturned;
    }

    public ThisGuy getGuy() {return guy;}
    public ThisStuff getStuff() {return stuff;}
    public LocalDate getDateBorrowed() {return dateBorrowed;}
    public LocalDate getDueDate() {return dueDate;}
    public LocalDate getDateReturned() {return dateReturned;}

    public void setDateReturned(LocalDate dateReturned) {this.dateReturned = dateReturned;}
}
