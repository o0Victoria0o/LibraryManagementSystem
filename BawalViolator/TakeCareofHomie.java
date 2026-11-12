package utils;

import borrower.Borrower;
import borrower.BorrowerManager;

import materials.Material;
import materials.MaterialsManager;
import materials.Book;
import materials.ThesisBook;
import materials.Journal;
import materials.Magazine;

import transaction.Transaction;
import transaction.TransactionManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class FileHandling {
    private static final String BORROWERS_FILE = "documents/borrowers.txt";
    private static final String MATERIALS_FILE = "documents/materials.txt";
    private static final String TRANSACTION_FILE = "documents/transactions.txt";

    public static void saveBorrowers(BorrowerManager manager){
        new File("data").mkdirs();

        PrintWriter saveData = new PrintWriter(new FileWriter(BORROWERS_FILE));
        for (Borrower b : manager.getAllBorrowers()){
            out.println()
        }
    }
}

}
public static void 
