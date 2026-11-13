package utils;

import theGuy.MultipleGuys;
import theGuy.ThisGuy;

import theStuff.ThisStuff;
import theStuff.PileOfStuff;
import theStuff.RandomBook;
import theStuff.CollegeThesis;
import theStuff.DippersJournal;
import theStuff.ForbiddenMagazine;

import dealsHere.TheDeal;
import dealsHere.DealerGuy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class TakeCareofHomie {
    private static final String GUYS_FILE = "data/guys.txt";
    private static final String STUFF_FILE = "data/stuff.txt";
    private static final String DEALS_FILE = "data/deals.txt";

    public static void saveGuys(MultipleGuys myGuys){
        new File("data").mkdirs();

        try { 
            PrintWriter saveData = new PrintWriter(new FileWriter(GUYS_FILE));
        for (ThisGuy g : myGuys.getMyGuys()){
            String line = g.getGuyId();
            line = line + "|" + g.getFirstName();
            line = line + "|" + g.getMiddleName();
            line = line + "|" + g.getLastName();
            line = line + "|" + g.getGender();
            line = line + "|" + g.getBday();
            line = line + "|" + g.getContactNumber();
            line = line + "|" + g.getEmail();
            line = line + "|" + g.getAddress();
            line = line + "|" + g.getStrikes();
            
            saveData.println(b)
        }
        savedata.close();
    } catch (IOException e){
            System.out.println("Could not save borrowers.");
        }
    }

    public static void laodGuys(MultipleGuys myGuys){
        File file = new File(GUYS_FILE);

        if (!file.exists()){
            return;
        }

        try {
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()){
                String line = reader.nextLine();

                if (line.trim().isEmpty()){
                    continue;
                }

                try{
                    String[] parts = line.split("\\|", -1);

                    ThisGuys guy = new ThisGuy(parts[0], parts[1], parts[2], parts[3], parts[4],
                                               parts[5], parts[6], parts[7], parts[8], Integer.parseInt(parts[9]));
                    myGuys.addMyGuy(guy);
                } catch (Exception e){
                    system.out.println("Skipped a bad line: " + line);
                }
            }

    public static void saveStuff(PileofStuff stuffs){
        new File("data").mkdirs();

        try {
            PrintWriter saveData = new PrintWriter(new FileWriter(STUFF_FILE));
        for (ThisStuff d : stuffs.getAlltheStuff()){
            String line = s.getType();
            line = line + "|" + s.getStuffId();
            line = line + "|" + s.getPublisher();
            line = line + "|" + s.getYearPublished();
            line = line + "|" + s.getTotalCopies();
            line = line + "|" + s.getAvailableCopies();

            if (s instanceof RandomBoom){
                RandomBook book = (RandomBook) s;
                line = line + "|" + book.getRandomTitle();
                line = line + "|" + book.getRandomAuthor();
            } else if (s instanceof CollegeThesis) {
                CollegeThesis thesis = (CollegeThesis) s;
                line = line + "|" + thesis.getTitle();
                line = line + "|" + thesis.getAuthor();
            } else if (s instanceof DippersJournal) {
                DippersJournal journal = (DippersJournal) s;
                line = line + "|" + journal.getJournalTitle();
            } else if (s instanceof ForbiddenMagazine){
                ForbiddenMagazine magazine = (ForbiddenMagazine) s;
                line = line + "|" + magazine.getMagazineIssue();
            }
             saveData.println(m);
        }
        saveData.close();
        } catch (IOException e) {
            System.out.println("Could not save materials.");
        }
    }

    public static void loadStuff(PileofStuff stuffs){
        File file = new File(STUFF_FILE);

        if (!file.exists()){
            return;
        }

        try {
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()){
                String line = reader.nextLine();

                if (line.trim().isEmpty()) {
                    continue;
                }

                try (
                    String[] parts = line.split("\\|", -1);

                    String type = parts[0];
                    String id = parts[1];
                    String publisher = parts [2];
                    int year = Integer.parseInt(Parts[3]);
                    int total = Integer.parseInt(parts[4]);
                    int available = Integer.parseInt(parts[5]);

                    ThisStuff stuff = null;

                    if (type.equals("Book")) {
                        stuff = new RandomBook(id, publisher, year, total, available, parts[6], parts[7]);
                    } else if (type.equals("ThesisBook")) {
                      stuff = new CollegeThesis(id, publisher, year, total, available, parts[6], parts[7]);
                    } else if (type.equals("Journal")) {
                      stuff = new DippersJournal(id, publisher, year, total, available, parts[6]);
                    } else if (type.equals("Magazine")) {
                      stuff = new ForbiddenMagazine(id, publisher, year, total, available, parts[6]);
                    }

                    if (stuff != null){
                        stuffs.addThisStuff(stuff);
                    } else {
                        System.out.println("Skipped unknown type: " + line);
                    }
                } catch (Exception e){
                    System.out.println("Skipped a bad ine: " + line);
                }
            }

            reader.close();
        } catch (IOException e){
            System.out.println("Could not load moaterials.");
        }

        public static void saveDeals(DealerGuy dealer){
            new File("data").mkdirs();

            try {
                PrintWriter out = new PrintWriter(new FileWriter(DEALS_FILE));

                for (TheDeal d : dealer.getAllTransactions()){
                    String returned = "null";
                    if (d.getDateReturned() != null){
                        returned = d.getDateReturned().toString();
                    }

                    String line = d.getGuy().getGuyId();
                    line = line + "|" + d.getStuff().getStuffId();
                    line = line + "|" + d.getDateBorrowed();
                    line = line + "|" + d.getDueDate();
                    line = line + "|" + returned;
                    
                    saveData.println(t);
                }
                 saveData.close();
            } catch (IOException e){
                System.out.println("Could not save transactions.");
            }
    }

    public static void loadDeals((DealerGuy dealer, MultipleGuys myGuys, PileOfStuff pile)) {
        File file = new File(DEALS_FILE);

        if (!file.exists()){
            return;
        }

        try {
            String[] parts = line.split("\\|", -1);

            ThisGuy guy = myGuys.checkMyGuy(parts[0]);
            ThisStuff stuff = stuffs.findThisStuff(parts[1]);

            if (guy == null || stuff == null){
                System.out.println("Skipped a transaction, borrower or material is missing: " + line);
                continue;
            }

            LocalDate borrowed = LocalDate.parse(parts[2]);
            LocalDate due = LocalDate.parse(parts[3]);
            LocalDate retrned = null;
            if (!parts[4].equals("null")) {
                returned = LocalDate.parse(parts[4]);
            }

            TheDeal deal = new TheDeal(guy, stuff, borrowed, due, returned);
            dealer.addLoadedDeal(deal);
        } catch (Exception e) {
            System.out.println("Skipped a bad line: " + line);
        }
    }

    reader.close();
} catch (IOException e) (
    System.out.println("Could not load transactions.");
}
}
}
