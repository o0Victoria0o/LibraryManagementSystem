package menuThings;

import dealsHere.DealerGuy;
import dealsHere.TheDeal;
import java.util.List;
import java.util.Scanner;
import theGuy.MultipleGuys;
import theGuy.ThisGuy;
import theStuff.PileOfStuff;
import theStuff.ThisStuff;

public class DealersMenu {
    private DealerGuy myDealer;
    private MultipleGuys myGuys;
    private PileOfStuff myPiles;
    private Scanner scan;

    public DealersMenu(DealerGuy myDealer, MultipleGuys myGuys, PileOfStuff myPiles, Scanner scan){
        this.myDealer = myDealer;
        this.myGuys = myGuys;
        this.myPiles = myPiles;
        this.scan = scan;
    }
    public void showMenuDealer() {
        String YourPick =  " ";
        while (!YourPick.equals("6")) {
            System.out.println();
            System.out.println("TRANSACTION MENU");
            System.out.println("1. Borrow materials");
            System.out.println("2. return materials");
            System.out.println("3. show borrower history");
            System.out.println("4. show material history");
            System.out.println("5. show all transactions");
            System.out.println("6. Back");
            System.out.println("Choose: ");
            YourPick = scan.nextLine().trim();
            
            if (YourPick.equals("1")) {
                grabTheStuff();
            } else if (YourPick.equals("2")) {
                giveItBack();
            } else if (YourPick.equals("3")) {
                whatDidTheGuyDo();
            }else if (YourPick.equals("4")) {
                whereHasTheStuffBeen();
            }else if (YourPick.equals("5")) {
                showEveryDeals();
            }else if (!YourPick.equals("6")) {
                System.out.println("Invalid YourPick, pick 1 to 6.");
            }
        }
    }
    private void grabTheStuff() {
        System.out.print("Enter Borrower ID: ");
        String guyId = scan.nextLine().trim();
        System.out.print("Enter Material ID:");
        String stuffId = scan.nextLine().trim();

        ThisGuy guy = myGuys.checkMyGuy(guyId);
        ThisStuff stuff = myPiles.findThisStuff(stuffId);
        
        boolean done = myDealer.borrowMaterial(guy, stuff);
        if (done){
            System.out.println("Borrowed:" + stuff.getDisplayName());
            System.out.println("Borrow duration:" + stuff.getBorrowDuration() + "days(s)");
        }
    }
    private void giveItBack() {
        System.out.print("Enter Borrowwer ID: ");
        String guyId = scan.nextLine().trim();
        System.out.print("Enter Material ID: ");
        String stuffId = scan.nextLine().trim();

        ThisGuy guy = myGuys.checkMyGuy(guyId);
        ThisStuff stuff = myPiles.findThisStuff(stuffId);

        boolean done = myDealer.returnMaterial(guy, stuff);
        if (done){
            System.out.println("Returned: " + stuff.getDisplayName());
        }
    }
    private void whatDidTheGuyDo(){
        System.out.print("Enter Borrower ID: ");
        String guyId = scan.nextLine().trim();
        ThisGuy guy = myGuys.checkMyGuy(guyId);
        myDealer.showBorrowerHistory(guy);
    }
    private void whereHasTheStuffBeen() {
        System.out.print("Enter Material ID: ");
        String stuffId = scan.nextLine().trim();
        ThisStuff stuff = myPiles.findThisStuff(stuffId);
        myDealer.showMaterialHistory(stuff);
    }
    private void showEveryDeals() {
        List<TheDeal> deals = myDealer.getAllTransactions();
        if(deals.isEmpty()) {
            System.out.println("No transactions yet.");
            return;
        }
        for (TheDeal d : deals) {
            String returned;
            if (d.getDateReturned() ==null) {
                returned = "Not yet returned";
            }else {
                returned = d.getDateReturned().toString();
            }
            System.out.println(d.getGuy().getFirstName() + " " + d.getGuy().getLastName()
            + " | Material ID: " + d.getStuff().getStuffId()
            + " | Borrowed: " + d.getDateBorrowed()
            + " | Due: " + d.getDueDate()
            + " | Returened: " + returned);
        }
    }
}
