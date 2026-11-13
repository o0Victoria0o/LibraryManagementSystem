package menuThings;

import bawalViolator.CheckHomie;
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

    public StuffMenu(Scanner sc, PileOfStuff listOfAsset){
        this.sc = sc;
        this.listOfAsset = listOfAsset;
    }

    public void showMenuStuff() {
        int YourPick = 0;

        do {
            System.out.println("ASSET MENU");
            System.out.println("[1] Add Material");
            System.out.println("[2] Edit Material");
            System.out.println("[3] Delete Material");
            System.out.println("[4] View Material");
            System.out.println("[5] Back");
            System.out.print("Choose: ");

            try{
            YourPick = Integer.parseInt(sc.nextLine().trim());
            }catch(NumberFormatException invalidPick){
                System.out.println("(1-6) Only");
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
                    System.out.println("Returning...");
                    break;
                default:
                    System.out.println("Invalid pick! Pick from 1-6.");
            }
        } while (YourPick !=6);
    }

    public void addAsset(){
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
            System.out.println("(1-4) Only");
            return;
        }

        if (yourPick < 1 || yourPick > 4){
            System.out.println("(1-4) Only");
            return;
        }

        System.out.print("Material ID: ");
        String stuffId = sc.nextLine().trim();
        if (stuffId.isEmpty()){
            System.out.println("Invalid, blank Id");
            return;
        }

        if (listOfAsset.findThisStuff(stuffId) != null) {
            System.out.println("Material already exists!");
            return;
        }

        System.out.println("Publisher: ");
        String publisher = sc.nextLine().trim();
        int yearPublished = readYear();
        int totalCopies = readCopies("Total copies: ");

        ThisStuff thisSpecificStuff = null;

        switch (yourPick){
            case 1:
                System.out.print("Book Title: "); String randomTitle = sc.nextLine();
                String randomAuthor = readName("Author: ");

                thisSpecificStuff = new RandomBook(stuffId, publisher, yearPublished, totalCopies, totalCopies, randomTitle, randomAuthor);
                break;

            case 2:
                System.out.print("Journal Name: "); String journalTitle = sc.nextLine();
                thisSpecificStuff = new DippersJournal(stuffId, publisher, yearPublished, totalCopies, totalCopies, journalTitle);
                break;

            case 3:
                System.out.print("Magazine Name: "); String magazineTitle = sc.nextLine();
                thisSpecificStuff = new ForbiddenMagazine(stuffId, publisher, yearPublished, totalCopies, totalCopies, magazineTitle);
                break;

            case 4: 
                System.out.print("Thesis Title: "); String thesisTitle = sc.nextLine();
                String thesisAuthor = readName("Author: ");

                thisSpecificStuff = new CollegeThesis(stuffId, publisher, yearPublished, totalCopies, totalCopies, thesisTitle, thesisAuthor);
                break;

            default:
                System.out.println("Invalid material type!");
                return;
        }
        listOfAsset.addThisStuff(thisSpecificStuff);;
        System.out.println("Material added successfully");
        
    }
    
    public void viewAsset() {
        System.out.print("Enter Material ID: ");
        String stuffId = sc.nextLine().trim();

        ThisStuff stuffToView = listOfAsset.findThisStuff(stuffId);

        if (stuffToView == null) {
            System.out.println("Material not found.");
            return;
        }

        showStuffDetails(stuffToView);
    }

    public void viewAllAssets() {
        System.out.println("Material List");
        if (listOfAsset.getThisStuffCount() == 0) {
            System.out.println("No materials found!");
            return;
        }

        for (ThisStuff thisSpecificStuff : listOfAsset.getAlltheStuff()) {
            showStuffDetails(thisSpecificStuff);
        }
    }

    public void deleteAsset() {
        System.out.println("Enter Material ID: ");
        String stuffId = sc.nextLine().trim();

        ThisStuff stuffToDelete = listOfAsset.findThisStuff(stuffId);

        if(stuffToDelete != null && stuffToDelete.getAvailableCopies() < stuffToDelete.getTotalCopies()){
            System.out.println("Cannot Delete Material");
            System.out.println("Some materials are still borrowed");
            return;
        }

        if (listOfAsset.removeThisStuff(stuffId)) {
            System.out.println("Material deleted.");
        } else {
            System.out.println("Material not found.");
        }
    }

    public void editAsset() {
        System.out.print("Enter Material ID: ");
        String stuffId = sc.nextLine().trim();

        ThisStuff thisStuffEdit = listOfAsset.findThisStuff(stuffId);

        if (thisStuffEdit == null) {
            System.out.println("Material not found.");
            return;
        }

        System.out.print("New Publisher: ");
        String newPublisher = sc.nextLine().trim();
        int newYear = readYear();
        int newTotalCopies = readCopies("New total copies: ");
        
        int borrowedCopies = thisStuffEdit.getTotalCopies() - thisStuffEdit.getAvailableCopies();

        if (newTotalCopies < borrowedCopies){
            System.out.println("Cannot go below borrowed copies: " + borrowedCopies);
            System.out.println("Edit not continued");
            return;
        }

        thisStuffEdit.setPublisher(newPublisher);
        thisStuffEdit.setYearPublished(newYear);
        thisStuffEdit.setTotalCopies(newTotalCopies);
        thisStuffEdit.setAvailableCopies(newTotalCopies - borrowedCopies);
        System.out.println("Materials updated");

    }

    private void showStuffDetails(ThisStuff thisSpecificStuff) {
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
                System.out.println("(A-z ,.-) Only");
            }
        } while (!CheckHomie.isValidName(name));
        return name;
    }
}


