package dealers;

import java.util.ArrayList;
import java.util.List;

import theGuy.ThisGuy;
import theStuff.ThisStuff;
import java.time.LocalDate;


public class TheDeal {
    private ArrayList<TheDeal> transactions = new ArrayList<TheDeal>();

    public boolean borrowMaterial(ThisGuy guy, ThisStuff stuff) {
        if (guy == null){
            System.out.println("Borrower is not registered.");
            return false;
        }
        if(stuffl== null){
            System.out.println("Material not found.");
            return false;
        }

        if (guy.getNumberOfViolations() >= 3) {
            System.out.println("Borrower has 3 or more strikes. Cannot borrow.");
            return false;
        }
        if (stuff.getAvailableCopies() <= 0){
            System.out.println("Material is not available.");
            return false;
        }

        for (TheDeal t: deals){
            if (t.getGuy().getguyId().equals(guy.getGuyId())
                && t.getDateReturned() == null){
                System.out.println("Can only borrow one material at a time.");
                return false;
                }
        }

        deals.add(new TheDeal(guy, stuff));
        stuff.setAvailableCopies(stuff.getAvailableCopies()-1);
        return true;
    }

    public boolean returnMaterial(ThisGuy guy, ThisStuff stuff) {
        if (guy == null){
            System.out.println("Borrower is not registered.");
            return false;
        }
        if(stuff== null){
            System.out.println("Material not found.");
            return false;
        }

        for (TheDeal d : deals){
            if (d.getGuy().getGuyId().equals(guy.getGuyId())
            && t.getStuff().getStuffId().equals(stuff.getStuffId())
            && t.getDateReturned() == null){

            d.setDateReturned(LocalDate.now());

            if(LocalDate.now().isAfter(t.getDueDate())){
                guy.setStrikes(guy,getStrikes()+1);
                System.out.println("Late Return, 1 Strike Added");
            }

            stuff.setAvailableCopies(stuff.getAvailableCopies()+1);
            return true;
            }
        }
        System.out.println("No active borrower record for this material.");
        return false;
    }

    public void showBorrowerHistory(ThisGuy guy) {
        if (borrower == null){
            System.out.println("Borrower not registered.");
            return;
        }
        for (Transaction t: transactions){
            if(d.getGuy().getGuyId().equals(guy.getGuyid())){
                printTransaction(t);
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

    public List<TheDeal> getAllTransactions() {
        return new ArrayList<>(deals);
    }

    private void printTransaction(TheDeals d) {
        String returned;
        if (d.getDateReturned() == null){
            returned = "Not yet returned";
        }
            else{
            returned = d.getDateReturned().toString();
        }
        
        System.out.println(t.get().getFirstName() + " " + t.getBorrower().getLastName()
        + " | Material ID: " + d.getStuff().getStuffId()
        + " | Borrowed: " + d.getDateBorrowed()
        + " | Due: " + t.getDueDate()
        + " | Returned: " + returned);
    }

