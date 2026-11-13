package theDataFiles;
 
import dealsHere.DealerGuy;
import dealsHere.TheDeal;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;
import theGuy.MultipleGuys;
import theGuy.ThisGuy;
import theStuff.CollegeThesis;
import theStuff.DippersJournal;
import theStuff.ForbiddenMagazine;
import theStuff.PileOfStuff;
import theStuff.RandomBook;
import theStuff.ThisStuff;
 
public class TakeCareofHomie {
    private static final String HOMIES_FILE = "data/guys.txt";
    private static final String STUFF_FILE = "data/stuff.txt";
    private static final String DEALS_FILE = "data/deals.txt";
 
    public static void saveTheHomies(MultipleGuys myGuys){
        new File("data").mkdirs();
 
        try {
            PrintWriter writeToFile = new PrintWriter(new FileWriter(HOMIES_FILE));
 
            for (ThisGuy thisSpecificHomie : myGuys.getMyGuys()){
                String lineForThisHomie = thisSpecificHomie.getGuyId();
                lineForThisHomie = lineForThisHomie + "|" + thisSpecificHomie.getFirstName();
                lineForThisHomie = lineForThisHomie + "|" + thisSpecificHomie.getMiddleName();
                lineForThisHomie = lineForThisHomie + "|" + thisSpecificHomie.getLastName();
                lineForThisHomie = lineForThisHomie + "|" + thisSpecificHomie.getGender();
                lineForThisHomie = lineForThisHomie + "|" + thisSpecificHomie.getBday();
                lineForThisHomie = lineForThisHomie + "|" + thisSpecificHomie.getContactNumber();
                lineForThisHomie = lineForThisHomie + "|" + thisSpecificHomie.getEmail();
                lineForThisHomie = lineForThisHomie + "|" + thisSpecificHomie.getAddress();
                lineForThisHomie = lineForThisHomie + "|" + thisSpecificHomie.getStrikes();
 
                writeToFile.println(lineForThisHomie);
            }
 
            writeToFile.close();
        } catch (IOException saveProblem){
            System.out.println("Could not save borrowers.");
        }
    }
 
    public static void loadTheHomies(MultipleGuys myGuys){
        File homiesFile = new File(HOMIES_FILE);
 
        if (!homiesFile.exists()){
            return;
        }
 
        try {
            Scanner readFromFile = new Scanner(homiesFile);
 
            while (readFromFile.hasNextLine()){
                String oneSavedLine = readFromFile.nextLine();
 
                if (oneSavedLine.trim().isEmpty()){
                    continue;
                }
 
                try {
                    String[] piecesOfTheLine = oneSavedLine.split("\\|", -1);
 
                    ThisGuy homieFromFile = new ThisGuy(piecesOfTheLine[0], piecesOfTheLine[1],
                            piecesOfTheLine[2], piecesOfTheLine[3], piecesOfTheLine[4],
                            piecesOfTheLine[5], piecesOfTheLine[6], piecesOfTheLine[7],
                            piecesOfTheLine[8], Integer.parseInt(piecesOfTheLine[9]));
                    myGuys.addMyGuy(homieFromFile);
                } catch (Exception badLine){
                    System.out.println("Skipped a bad line: " + oneSavedLine);
                }
            }
 
            readFromFile.close();
        } catch (IOException loadProblem){
            System.out.println("Could not load borrowers.");
        }
    }
 
    public static void saveTheStuff(PileOfStuff myPiles){
        new File("data").mkdirs();
 
        try {
            PrintWriter writeToFile = new PrintWriter(new FileWriter(STUFF_FILE));
 
            for (ThisStuff thisSpecificStuff : myPiles.getAlltheStuff()){
                String lineForThisStuff = thisSpecificStuff.getType();
                lineForThisStuff = lineForThisStuff + "|" + thisSpecificStuff.getStuffId();
                lineForThisStuff = lineForThisStuff + "|" + thisSpecificStuff.getPublisher();
                lineForThisStuff = lineForThisStuff + "|" + thisSpecificStuff.getYearPublished();
                lineForThisStuff = lineForThisStuff + "|" + thisSpecificStuff.getTotalCopies();
                lineForThisStuff = lineForThisStuff + "|" + thisSpecificStuff.getAvailableCopies();
 
                if (thisSpecificStuff instanceof RandomBook){
                    RandomBook thisBook = (RandomBook) thisSpecificStuff;
                    lineForThisStuff = lineForThisStuff + "|" + thisBook.getRandomTitle();
                    lineForThisStuff = lineForThisStuff + "|" + thisBook.getRandomAuthor();
                } else if (thisSpecificStuff instanceof CollegeThesis) {
                    CollegeThesis thisThesis = (CollegeThesis) thisSpecificStuff;
                    lineForThisStuff = lineForThisStuff + "|" + thisThesis.getTitle();
                    lineForThisStuff = lineForThisStuff + "|" + thisThesis.getAuthor();
                } else if (thisSpecificStuff instanceof DippersJournal) {
                    DippersJournal thisJournal = (DippersJournal) thisSpecificStuff;
                    lineForThisStuff = lineForThisStuff + "|" + thisJournal.getJournalTitle();
                } else if (thisSpecificStuff instanceof ForbiddenMagazine){
                    ForbiddenMagazine thisMagazine = (ForbiddenMagazine) thisSpecificStuff;
                    lineForThisStuff = lineForThisStuff + "|" + thisMagazine.getMagazineIssue();
                }
 
                writeToFile.println(lineForThisStuff);
            }
 
            writeToFile.close();
        } catch (IOException saveProblem) {
            System.out.println("Could not save materials.");
        }
    }
 
    public static void loadTheStuff(PileOfStuff myPiles){
        File stuffFile = new File(STUFF_FILE);
 
        if (!stuffFile.exists()){
            return;
        }
 
        try {
            Scanner readFromFile = new Scanner(stuffFile);
 
            while (readFromFile.hasNextLine()){
                String oneSavedLine = readFromFile.nextLine();
 
                if (oneSavedLine.trim().isEmpty()) {
                    continue;
                }
 
                try {
                    String[] piecesOfTheLine = oneSavedLine.split("\\|", -1);
 
                    String typeOfStuff = piecesOfTheLine[0];
                    String idOfStuff = piecesOfTheLine[1];
                    String publisherOfStuff = piecesOfTheLine[2];
                    int yearOfStuff = Integer.parseInt(piecesOfTheLine[3]);
                    int totalCopiesOfStuff = Integer.parseInt(piecesOfTheLine[4]);
                    int availableCopiesOfStuff = Integer.parseInt(piecesOfTheLine[5]);
 
                    ThisStuff stuffFromFile = null;
 
                    if (typeOfStuff.equals("Book")) {
                        stuffFromFile = new RandomBook(idOfStuff, publisherOfStuff, yearOfStuff,
                                totalCopiesOfStuff, availableCopiesOfStuff,
                                piecesOfTheLine[6], piecesOfTheLine[7]);
                    } else if (typeOfStuff.equals("ThesisBook")) {
                        stuffFromFile = new CollegeThesis(idOfStuff, publisherOfStuff, yearOfStuff,
                                totalCopiesOfStuff, availableCopiesOfStuff,
                                piecesOfTheLine[6], piecesOfTheLine[7]);
                    } else if (typeOfStuff.equals("Journal")) {
                        stuffFromFile = new DippersJournal(idOfStuff, publisherOfStuff, yearOfStuff,
                                totalCopiesOfStuff, availableCopiesOfStuff,
                                piecesOfTheLine[6]);
                    } else if (typeOfStuff.equals("Magazine")) {
                        stuffFromFile = new ForbiddenMagazine(idOfStuff, publisherOfStuff, yearOfStuff,
                                totalCopiesOfStuff, availableCopiesOfStuff,
                                piecesOfTheLine[6]);
                    }
 
                    if (stuffFromFile != null){
                        myPiles.addThisStuff(stuffFromFile);
                    } else {
                        System.out.println("Skipped unknown type: " + oneSavedLine);
                    }
                } catch (Exception badLine){
                    System.out.println("Skipped a bad line: " + oneSavedLine);
                }
            }
 
            readFromFile.close();
        } catch (IOException loadProblem){
            System.out.println("Could not load materials.");
        }
    }
 
    public static void saveTheDeals(DealerGuy myDealer){
        new File("data").mkdirs();
 
        try {
            PrintWriter writeToFile = new PrintWriter(new FileWriter(DEALS_FILE));
 
            for (TheDeal thisSpecificDeal : myDealer.getAllTransactions()){
                String dateReturnedText = "null";
                if (thisSpecificDeal.getDateReturned() != null){
                    dateReturnedText = thisSpecificDeal.getDateReturned().toString();
                }
 
                String lineForThisDeal = thisSpecificDeal.getGuy().getGuyId();
                lineForThisDeal = lineForThisDeal + "|" + thisSpecificDeal.getStuff().getStuffId();
                lineForThisDeal = lineForThisDeal + "|" + thisSpecificDeal.getDateBorrowed();
                lineForThisDeal = lineForThisDeal + "|" + thisSpecificDeal.getDueDate();
                lineForThisDeal = lineForThisDeal + "|" + dateReturnedText;
 
                writeToFile.println(lineForThisDeal);
            }
 
            writeToFile.close();
        } catch (IOException saveProblem){
            System.out.println("Could not save transactions.");
        }
    }
 
    public static void loadTheDeals(DealerGuy myDealer, MultipleGuys myGuys, PileOfStuff myPiles) {
        File dealsFile = new File(DEALS_FILE);
 
        if (!dealsFile.exists()){
            return;
        }
 
        try {
            Scanner readFromFile = new Scanner(dealsFile);
 
            while (readFromFile.hasNextLine()){
                String oneSavedLine = readFromFile.nextLine();
 
                if (oneSavedLine.trim().isEmpty()){
                    continue;
                }
 
                try {
                    String[] piecesOfTheLine = oneSavedLine.split("\\|", -1);
 
                    ThisGuy homieWeFound = myGuys.checkMyGuy(piecesOfTheLine[0]);
                    ThisStuff stuffWeFound = myPiles.findThisStuff(piecesOfTheLine[1]);
 
                    if (homieWeFound == null || stuffWeFound == null){
                        System.out.println("Skipped a transaction, borrower or material is missing: " + oneSavedLine);
                        continue;
                    }
 
                    LocalDate dateBorrowed = LocalDate.parse(piecesOfTheLine[2]);
                    LocalDate dateDue = LocalDate.parse(piecesOfTheLine[3]);
                    LocalDate dateReturned = null;
                    if (!piecesOfTheLine[4].equals("null")) {
                        dateReturned = LocalDate.parse(piecesOfTheLine[4]);
                    }
 
                    TheDeal dealFromFile = new TheDeal(homieWeFound, stuffWeFound,
                            dateBorrowed, dateDue, dateReturned);
                    myDealer.addLoadedDeal(dealFromFile);
                } catch (Exception badLine) {
                    System.out.println("Skipped a bad line: " + oneSavedLine);
                }
            }
 
            readFromFile.close();
        } catch (IOException loadProblem) {
            System.out.println("Could not load transactions.");
        }
    }
}