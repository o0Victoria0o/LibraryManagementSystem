package menuThings;

import bawalViolator.CheckHomie;
import dealsHere.DealerGuy;
import java.util.Scanner;
import theStuff.CollegeThesis;
import theStuff.DippersJournal;
import theStuff.ForbiddenMagazine;
import theStuff.PileOfStuff;
import theStuff.RandomBook;
import theStuff.ThisStuff;
public class StuffMenu {
    private Scanner sc = new Scanner(System.in);
    private PileOfStuff listOfAsset = new PileOfStuff();
    private DealerGuy myDealer = new DealerGuy();

    public StuffMenu(Scanner sc, PileOfStuff listOfAsset, DealerGuy myDealer){
        this.sc = sc;
        this.listOfAsset = listOfAsset;
        this.myDealer = myDealer;
    }

    public void showMenuStuff() {
        int YourPick = 0;

        do {
            System.out.println();
            System.out.println("------Material Menu------");
            System.out.println("[1] Add Material");
            System.out.println("[2] Edit Material");
            System.out.println("[3] Delete Material");
            System.out.println("[4] View Material");
            System.out.println("[5] View All Materials");
            System.out.println("[6] Back");
            System.out.print("Choose: ");

            try{
            YourPick = Integer.parseInt(sc.nextLine().trim());
            }catch(NumberFormatException invalidPick){
                System.out.println("Invalid, (1-6) only");
                continue;
            }

            switch (YourPick) {
                case 1:
                    addAsset();
                    break;
                case 2:
                    editAsset();
                    break;
                case 3:
                    deleteAsset();
                    break;
                case 4:
                    viewAsset();
                    break;
                case 5:
                    viewAllAssets();
                    break;
                case 6:
                    System.out.println("Returning to main menu");
                    break;
                default:
                    System.out.println("Invalid, (1-6) only");
            }
        } while (YourPick !=6);
    }

    public void addAsset(){
        System.out.println();
        System.out.println("-----Add Material-----");
        System.out.println("[1] Book");
        System.out.println("[2] Journal");
        System.out.println("[3] Magazine");
        System.out.println("[4] Thesis Book");
        System.out.print("Pick a material: ");

        int yourPick = 0;
        try{
        yourPick = Integer.parseInt(sc.nextLine().trim());
        }
        catch(NumberFormatException invalidPick){
            System.out.println("Invalid, (1-4) Only");
            return;
        }

        if (yourPick < 1 || yourPick > 4){
            System.out.println("Invalid, (1-4) Only");
            return;
        }

        System.out.print("Material ID: ");
        String stuffId = sc.nextLine().trim();
        if (stuffId.isEmpty()){
            System.out.println("Invalid, blank ID");
            return;
        }

        if (listOfAsset.findThisStuff(stuffId) != null) {
            System.out.println("Material already exists");
            return;
        }

        String publisher = readTextForMaterials("Publisher: ");
        int yearPublished = readYear();
        int totalCopies = readCopies("Total copies: ");

        ThisStuff thisSpecificStuff = null;

        switch (yourPick){
            case 1:
                String randomTitle = readTextForMaterials("Book Title: ");
                String randomAuthor = readName("Author: ");

                thisSpecificStuff = new RandomBook(stuffId, publisher, yearPublished, totalCopies, totalCopies, randomTitle, randomAuthor);
                break;

            case 2:
                String journalTitle = readTextForMaterials("Journal Name: ");
                thisSpecificStuff = new DippersJournal(stuffId, publisher, yearPublished, totalCopies, totalCopies, journalTitle);
                break;

            case 3:
                String magazineTitle = readTextForMaterials("Magazine Name: ");
                thisSpecificStuff = new ForbiddenMagazine(stuffId, publisher, yearPublished, totalCopies, totalCopies, magazineTitle);
                break;

            case 4: 
                String thesisTitle = readTextForMaterials("Thesis Title: ");
                String thesisAuthor = readName("Author: ");

                thisSpecificStuff = new CollegeThesis(stuffId, publisher, yearPublished, totalCopies, totalCopies, thesisTitle, thesisAuthor);
                break;

            default:
                System.out.println("Invalid material type");
                return;
        }
        if (listOfAsset.addThisStuff(thisSpecificStuff)){
        System.out.println("Material added successfully");
        }
        else{
        System.out.println("Material not added");
        }
        
    }
    
    public void viewAsset() {
        System.out.println();
        System.out.println("-----View Material-----");
        System.out.print("Enter Material ID: ");
        String stuffId = sc.nextLine().trim();

        ThisStuff stuffToView = listOfAsset.findThisStuff(stuffId);

        if (stuffToView == null) {
            System.out.println("Material not found");
            return;
        }

        showStuffDetails(stuffToView);
    }

    public void viewAllAssets() {
        if (listOfAsset.getThisStuffCount() == 0) {
            System.out.println("No materials found!");
            return;
        }
        System.out.println();
        System.out.println("-----All Materials-----");
        for (ThisStuff thisSpecificStuff : listOfAsset.getAlltheStuff()) {
            showStuffDetails(thisSpecificStuff);
        }
    }

    public void deleteAsset() {
        System.out.println();
        System.out.println("-----Remove Material-----");
        System.out.print("Enter Material ID: ");
        String stuffId = sc.nextLine().trim();

        ThisStuff stuffToDelete = listOfAsset.findThisStuff(stuffId);

        if(stuffToDelete != null && stuffToDelete.getAvailableCopies() < stuffToDelete.getTotalCopies()){
            System.out.println("Cannot remove material");
            System.out.println("Some materials are still borrowed");
            return;
        }
        if (myDealer.stuffHasHistory(stuffToDelete)){
            System.out.println("Cannot remove material");
            System.out.println("Has borrowing history");
            return;
        }

        if (listOfAsset.removeThisStuff(stuffId)) {
            System.out.println("Material deleted");
        } else {
            System.out.println("Material not found");
        }
    }

    public void editAsset() {
    System.out.print("Enter Material ID: ");
    String stuffId = sc.nextLine().trim();

    ThisStuff thisStuffEdit = listOfAsset.findThisStuff(stuffId);

    if (thisStuffEdit == null) {
        System.out.println("Material not found");
        return;
    }
        System.out.println();
        System.out.println("-----Edit Material-----");
        System.out.println("[1] Publisher");
        System.out.println("[2] Year published");
        System.out.println("[3] Total copies");
        System.out.println("[4] Title / Name");
        System.out.println("[5] Author");
        System.out.println("[6] Back");
        System.out.print("Choose: ");

        int choice;
            try{
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException invalidPick){
                System.out.println("Invalid, (1-6) only");
                return;
            }   

        switch (choice){
            case 1:
                thisStuffEdit.setPublisher(readTextForMaterials("New publisher: "));
                System.out.println("Publisher updated");
                break;
            case 2:
                thisStuffEdit.setYearPublished(readYear());
                System.out.println("Year updated");
                break;
            case 3: {
                int newTotalCopies = readCopies("New total copies: ");
                int borrowedCopies = thisStuffEdit.getTotalCopies() - thisStuffEdit.getAvailableCopies();
                if (newTotalCopies < borrowedCopies){
                    System.out.println("Cannot go below borrowed copies: " + borrowedCopies);
                    break;
                }
                thisStuffEdit.setTotalCopies(newTotalCopies);
                thisStuffEdit.setAvailableCopies(newTotalCopies - borrowedCopies);
                System.out.println("Copies updated");
                break;
            }
            case 4:
                editTitle(thisStuffEdit);
                break;
            case 5:
                editAuthor(thisStuffEdit);
                break;
            case 6:
                break;
            default:
                System.out.println("Invalid, (1-6) only");
                break;
        }
    }

    private void editTitle(ThisStuff thisStuffEdit){
        if (thisStuffEdit instanceof RandomBook){
            ((RandomBook) thisStuffEdit).setRandomTitle(readTextForMaterials("New book title: "));
        } else if (thisStuffEdit instanceof CollegeThesis){
            ((CollegeThesis) thisStuffEdit).setTitle(readTextForMaterials("New thesis title: "));
        } else if (thisStuffEdit instanceof DippersJournal){
            ((DippersJournal) thisStuffEdit).setJournalTitle(readTextForMaterials("New journal name: "));
        } else if (thisStuffEdit instanceof ForbiddenMagazine){
            ((ForbiddenMagazine) thisStuffEdit).setMagazineIssue(readTextForMaterials("New magazine name: "));
        }
        System.out.println("Title updated");
    }

    private void editAuthor(ThisStuff thisStuffEdit){
        if (thisStuffEdit instanceof RandomBook){
            ((RandomBook) thisStuffEdit).setRandomAuthor(readName("New author: "));
            System.out.println("Author updated");
        } else if (thisStuffEdit instanceof CollegeThesis){
            ((CollegeThesis) thisStuffEdit).setAuthor(readName("New author: "));
            System.out.println("Author updated");
        } else {
            System.out.println("This material has no author");
        }
    }

    private void showStuffDetails(ThisStuff thisSpecificStuff) {

        System.out.println();
        System.out.println("-----Material Details-----");
        System.out.println("Material ID: " + thisSpecificStuff.getStuffId());
        System.out.println("Type: " + thisSpecificStuff.getType());
        System.out.println("Name: " + thisSpecificStuff.getDisplayName());
        
        if (thisSpecificStuff instanceof RandomBook){
            System.out.println("Author: " + ((RandomBook) thisSpecificStuff).getRandomAuthor());
        }
        else if (thisSpecificStuff instanceof CollegeThesis){
            System.out.println("Author: " + ((CollegeThesis) thisSpecificStuff).getAuthor());
        }

        System.out.println("Publisher: " + thisSpecificStuff.getPublisher());
        System.out.println("Year: " + thisSpecificStuff.getYearPublished());
        System.out.println("Total Copies: " + thisSpecificStuff.getTotalCopies());
        System.out.println("Available Copies: " + thisSpecificStuff.getAvailableCopies());
    }


    private int readYear(){
        String year;
        do{
            System.out.print("Year published: ");
            year = sc.nextLine().trim();
            if (!CheckHomie.isValidYear(year)){
                System.out.println("Invalid published year");
                System.out.println("Cannot be future year");
            }
        }while(!CheckHomie.isValidYear(year));
        return Integer.parseInt(year);
    }

    private int readCopies(String prompt){
        String copies;
        do{
            System.out.print(prompt);
            copies = sc.nextLine().trim();
            if (!CheckHomie.isValidCopies(copies)){
                System.out.println("Invalid copies amount");
                System.out.println("Must be atleast 1 copy");
            }
        }while(!CheckHomie.isValidCopies(copies));
        return Integer.parseInt(copies);
    }

    private String readName(String prompt){
        String name;
        do { 
            System.out.print(prompt);
            name = sc.nextLine().trim();
            if (!CheckHomie.isValidName(name)){
                System.out.println("Invalid name");
                System.out.println("(A-Z ,.-) Only");
            }
        } while (!CheckHomie.isValidName(name));
        return name;
    }

    private String readTextForMaterials(String prompt){
        String input;
        do { 
            System.out.println(prompt);
            input = sc.nextLine().trim();
                if (input.isEmpty()){
                    System.out.println("Cannot be blank");
                }
        } while (input.isEmpty());
        return input;
    }
}


