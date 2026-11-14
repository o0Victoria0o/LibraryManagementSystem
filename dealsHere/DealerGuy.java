package dealsHere;

import java.util.ArrayList;
import java.util.List;

import theGuy.ThisGuy;
import theStuff.ThisStuff;
import java.time.LocalDate;


public class DealerGuy {
    private ArrayList<TheDeal> deals = new ArrayList<TheDeal>();
    public boolean borrowMaterial(ThisGuy guy, ThisStuff stuff) {
        if (guy == null){
            System.out.println("Borrower not registered");
            return false;
        }
        if(stuff== null){
            System.out.println("Material not found");
            return false;
        }

        if (guy.getStrikes() >= 3) {
            System.out.println("Borrower has 3 or more strikes. Cannot borrow");
            return false;
        }
        if (stuff.getAvailableCopies() <= 0){
            System.out.println("Material is not available");
            return false;
        }

        for (TheDeal d: deals){
            if (d.getGuy().getGuyId().equals(guy.getGuyId())
                && d.getDateReturned() == null){
                System.out.println("Can only borrow one material at a time");
                return false;
                }
        }

        deals.add(new TheDeal(guy, stuff));
        stuff.setAvailableCopies(stuff.getAvailableCopies()-1);
        return true;
    }

    public boolean returnMaterial(ThisGuy guy, ThisStuff stuff) {
        if (guy == null){
            System.out.println("Borrower is not registered");
            return false;
        }
        if(stuff== null){
            System.out.println("Material not found");
            return false;
        }

        for (TheDeal d : deals){
            if (d.getGuy().getGuyId().equals(guy.getGuyId())
            && d.getStuff().getStuffId().equals(stuff.getStuffId())
            && d.getDateReturned() == null){
            d.setDateReturned(LocalDate.now());
            if(LocalDate.now().isAfter(d.getDueDate())){
                guy.setStrikes(guy.getStrikes()+1);
                System.out.println("Late Return, 1 Strike Added");
            }
            stuff.setAvailableCopies(stuff.getAvailableCopies()+1);
            return true;
            }
        }
        System.out.println("No active borrower record for this material");
        return false;
        }
    
    public boolean hasActiveDeal(ThisGuy guy){
        for (TheDeal d : deals){
            if (d.getGuy().getGuyId().equals(guy.getGuyId()) && d.getDateReturned() == null){
                return true; //note, essentially says it has ongoing deal for one guy
            }
        }
        return false;
    }

    public void showBorrowerHistory(ThisGuy guy) {
        if (guy == null){
            System.out.println("Borrower not registered");
            return;
        }
        for (TheDeal d: deals){
            if (d.getGuy().getGuyId().equals(guy.getGuyId())){
                printTransaction(d);
                }
            }
        }

    public void showMaterialHistory(ThisStuff stuff) {
        if (stuff == null) {
            System.out.println("No Material Found.");
            return;
        }
        for (TheDeal d: deals){
            if(d.getStuff().getStuffId().equals(stuff.getStuffId())) {
                printTransaction(d);
            }
        }
    }
    public void addLoadedDeal(TheDeal deal) {
       deals.add(deal);
    }

    public List<TheDeal> getAllTransactions() {
        return new ArrayList<>(deals);
    }
    private void printTransaction(TheDeal d) {
        String returned;
        if (d.getDateReturned() == null){
            returned = "Not yet returned";
        }
            else{
            returned = d.getDateReturned().toString();
        }
        
        System.out.println(d.getGuy().getFirstName() + " " + d.getGuy().getLastName()
        + " | Material ID: " + d.getStuff().getStuffId()
        + " | Borrowed: " + d.getDateBorrowed()
        + " | Due: " + d.getDueDate()
        + " | Returned: " + returned);
    }
}

