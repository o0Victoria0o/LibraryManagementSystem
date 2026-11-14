package bawalViolator;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class CheckHomie {
    public static boolean isValidName(String name){
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        return name.matches("[\\p{L} .'-]+");
    }

    public static boolean isValidContact(String contactNumber) {
        if (contactNumber == null || contactNumber.trim().isEmpty()) {
            return false;
        }
        return contactNumber.matches("09[0-9]{9}");
    }

    public static boolean isValidEmail(String email){
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        return email.matches("[A-Za-z0-9._-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}");
    }

    public static boolean isValidBday(String bday){
        if (bday == null || bday.trim().isEmpty()) {
            return false;
        }
        try {
            LocalDate date = LocalDate.parse(bday.trim());
            return !date.isAfter(LocalDate.now());
        
        } catch (DateTimeParseException notValidBday) {
            return false;
        }
    }


    //2nd validyear passes here
    public static boolean isValidYear(int year){
        return year > 0 && year <= LocalDate.now().getYear();
    }


    // This is essentially safe guard for null inputs for year
    public static boolean isValidYear(String yearString){
        if (yearString == null || yearString.trim().isEmpty()) {
            return false;
        }
        try {
            int year = Integer.parseInt(yearString.trim());
            return isValidYear(year);
        } catch (NumberFormatException notValidYear) {
            return false;
        }
    }

    public static boolean isValidCopies(int copies){
        return copies > 0;
    }

    //same logic here from year, but for copies, to avoid null inputs
    public static boolean isValidCopies(String copiesString){
        if (copiesString == null || copiesString.trim().isEmpty()) {
            return false;
        }
        try {
            int copies = Integer.parseInt(copiesString.trim());
            return isValidCopies(copies);
        } catch (NumberFormatException notValidCopies) {
            return false;
        }
    }
}
