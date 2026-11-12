package menuThings;

import java.util.List;
import java.util.Scanner;

import theStuff.CollegeThesis;
import theStuff.DippersJournal;
import theStuff.ForbiddenMagazine;
import theStuff.PileOfStuff;
import theStuff.RandomBook;
import theStuff.ThisStuff;

public class assetMenu {
    private Scanner scanner = new Scanner(System.in);
    private PileOfStuff assetList = new PileOfStuff();

    public void assetMenu() {
        int YourPick;

        do {
            System.out.println("ASSET MENU");
            System.out.println("[1] Add Material");
            System.out.println("[2] Edit Material");
            System.out.println("[3] Delete Material");
            System.out.println("[4] View Material");
            System.out.println("[5] Back");
            System.out.print("Choose: ");
            YourPick = Integer.parseInt(scanner.nextLine());

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
                    viewAssets();
                    break;
                case 5:
                    System.out.println("Returning...");
                    break;
                default:
                    System.out.println("Invalid pick! Pick from 1-5.");
            }
        } while (YourPick !=5);
    }

    public void addAsset(){
        System.out.println("[1] Book");
        System.out.println("[2] Journal");
        System.out.println("[3] Magazine");
        System.out.println("[4] Thesis Book");
        System.out.print("Pick a material: ");

        int type = Integer.parseInt(scanner.nextLine());

        System.out.println("Material ID: ");
        String stuffId = scanner.nextLine();

        if (assetList.findThisStuff(stuffId) != null) {
            System.out.println("Material already exists!");
            return;
        }

        System.out.print("Publisher: "); String publisher = scanner.nextLine();
        System.out.print("Year Published: "); int yearPublished = Integer.parseInt(scanner.nextLine());
        System.out.print("Total Copies: "); int totalCopies = Integer.parseInt(scanner.nextLine());

        if (totalCopies <= 0) {
            System.out.println("Invalid number of copies!");
            return;
        }

        ThisStuff material = null;

        switch (YourType) {
            case 1: 
            System.out.print("Book Title: "); String randomTitle = scanner.nextLine();
            System.out.print("Author: "); String randomAuthor = scanner.nextLine();

            material = new RandomBook(stuffId, publisher, yearPublished, totalCopies, totalCopies, randomTitle, randomAuthor);
            break;

            case 2:
            System.out.println("Journal Name: "); String journalTitle = scanner.nextLine();

            material = new DippersJournal(stuffId, publisher, yearPublished, totalCopies, totalCopies, journalTitle);
            break;

            case 3:
            System.out.println("Magazine NameL: "); String magazineTitle = scanner.nextLine();

            material = new ForbiddenMagazine(stuffId, publisher, yearPublished, totalCopies, totalCopies, magazineTitle);
            break;

            case 4: 
            System.out.println("Thesis Title: "); String thesisTitle = scanner.nextLine();
            System.out.print("Author "); String thesisAuthor = scanner.nextLine();

            material = new CollegeThesis(stuffId, publisher, yearPublished, totalCopies, totalCopies, thesisTitle, thesisAuthor);
            break;

            default:
            System.out.println("Invalid material type!");
            return;
        }

            assetList.addThisStuff(material);
            System.out.println()("Material added successfully!");
    }

    public void viewAssets() {
        System.out.println("Material List");
        if (assetList.getThisStuffCount() == 0) {
            System.out.println("No materials found!");
            return;
        }

        for (ThisStuff material : assetList.getAlltheStuff()) {
            System.out.println("Material ID: " + material.getStuffId());
            System.out.println("Type: " + material.getType());
            System.out.println("Name: " + material.getDisplayName());
            System.out.println("Publisher: " + material.getPublisher());
            System.out.println("Year: " + material.getYearPublished());
            System.out.println("Total Copies: " + material.getTotalCopies());
            System.out.println("Available Copies: " + material.getAvailableCopies());
        }
    }

    public void deleteAsset() {
        System.out.println("Enter Material ID: ");
        String stuffId = scanner.nextLine();

        if (assetList.removeThisStuff(stuffId)) {
            System.out.println("Material deleted.");
        } else {
            System.out.println("Material not found.");
        }
    }

    public void editAsset() {
        System.out.print("Enter Material ID: ");
        String stuffId = scanner.nextLine();

        ThisStuff material = assetList.findThisStuff(stuffId);

        if (material == null) {
            System.out.println("Material not found.");
            return;
        }

        System.out.print("New Publisher: "); material.setPublisher(scanner.nextLine());
        System.out.print("Year: "); material.setYearPublished(Integer.parseInt(scanner.nextLine()));
        System.out.print("New Total Copies: "); int totalCopies = Integer.parseInt(scanner.nextLine());

        if (totalCopies < 0) {
            System.out.println("Invalid number of copies. Try Again.");
            return;
        }

        int borrowed = material.getTotalCopies() - material.getAvailableCopies();
    
    }
}

