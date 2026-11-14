package menuThings;

import dealsHere.DealerGuy;
import java.util.Scanner;
import theDataFiles.TakeCareofHomie;
import theGuy.MultipleGuys;
import theStuff.PileOfStuff;

public class MainMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        MultipleGuys myGuys = new MultipleGuys();
        PileOfStuff myPiles = new PileOfStuff();
        DealerGuy myDealer = new DealerGuy();

        TakeCareofHomie.loadTheHomies(myGuys);
        TakeCareofHomie.loadTheStuff(myPiles);
        TakeCareofHomie.loadTheDeals(myDealer, myGuys, myPiles);

        GuysMenu theGuysMenu = new GuysMenu(myGuys, myDealer, sc);
        StuffMenu theStuffsMenu = new StuffMenu(sc, myPiles);
        DealersMenu theDealersMenu = new DealersMenu(myDealer, myGuys, myPiles, sc);

        int YourPick = 0;

        while (YourPick !=4){
            System.out.println("--------Main Menu--------");
            System.out.println("[1] Borrower Management");
            System.out.println("[2] Material Management");
            System.out.println("[3] Transactions");
            System.out.println("[4] Exit");
            System.out.println("--------------------------");
            System.out.print("Choose: ");

            try {
                YourPick = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException invalidPick) {
                System.out.println("(1-4) Only");
                continue;
            }

            switch (YourPick){
                case 1:
                    theGuysMenu.showMenuGuys();
                    break;
                case 2:
                    theStuffsMenu.showMenuStuff();
                    break;
                case 3:
                    theDealersMenu.showMenuDealer();
                    break;
                case 4:
                    System.out.println("Exiting the Program");
                    break;
                default:
                    System.out.println("(1-4) Only");
                    break;
                    
            }
        }

        TakeCareofHomie.saveTheHomies(myGuys);
        TakeCareofHomie.saveTheStuff(myPiles);
        TakeCareofHomie.saveTheDeals(myDealer);

        sc.close();

    }
    
}
