package menuThings;

import bawalViolator.CheckHomie;
import dealsHere.DealerGuy;
import java.util.List;
import java.util.Scanner;
import theGuy.MultipleGuys;
import theGuy.ThisGuy;

public class GuysMenu {
    private MultipleGuys myGuys;
    private Scanner sc;
    private DealerGuy myDealer;

    public GuysMenu(MultipleGuys myGuys, DealerGuy myDealer, Scanner sc){
        this.myGuys = myGuys;
        this.myDealer = myDealer;
        this.sc = sc;
    }

    public void showMenuGuys(){
        int YourPick = 0;

        while (YourPick != 6){
        System.out.println("-------Guys Menu-------");
        System.out.println("1. Add borrower");
        System.out.println("2. Edit borrower");
        System.out.println("3. Remove borrower");
        System.out.println("4. View borrower");
        System.out.println("5. View all borrowers");
        System.out.println("6. Back");
        System.out.print("Choose: ");
        
        try{
            YourPick = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException invalidPick){
            System.out.println("Invalid input. (1-6) only");
            continue;
            }

        switch (YourPick){
            case 1:
                addNewGuy();
                break;
            case 2:
                editGuy();
                break;
            case 3:
                removeGuy();
                break;
            case 4:
                viewGuy();
                break;
            case 5:
                viewAllGuys();
                break;
            case 6:
                System.out.println("Returning to main menu");
                break;
            default:
                System.out.println("Invalid input. (1-6) only");
                break;
            }
        }
    }

    private void addNewGuy(){
    System.out.println("Borrower Id: ");
    String id = sc.nextLine().trim();

    if (id.isEmpty()){
        System.out.println("Invalid, blank Id");
        return;
    }
    if (myGuys.checkMyGuy(id) != null){
        System.out.println("Borrower already exists");
        return;
    }

        String firstName = readName("Enter first name: ");
        String middleName = readName("Enter middle name: ");
        String lastName = readName("Enter last name: ");

        System.out.println("Enter gender: ");
        String gender = sc.nextLine().trim();

        String bday = readBday();
        String contact = readContact();
        String email = readEmail();

        System.out.println("Enter address: ");
        String address = sc.nextLine().trim();

        ThisGuy newGuy = new ThisGuy(id, firstName, middleName, lastName, 
        gender, bday, contact, email, address, 0);

        if (myGuys.addMyGuy(newGuy)) {
            System.out.println("Borrower added successfully.");
        } else {
            System.out.println("Failed to add borrower.");
        }
    }

public void editGuy() {
    System.out.println("Borrower Id: ");
    String id = sc.nextLine().trim();

    ThisGuy guyToEdit = myGuys.checkMyGuy(id);
    if (guyToEdit == null) {
        System.out.println("Borrower not found.");
        return;
    }

    System.out.println("-----Edit Borrower-----");
    System.out.println("1. First Name");
    System.out.println("2. Middle Name");
    System.out.println("3. Last Name");
    System.out.println("4. Gender");
    System.out.println("5. Birthday");
    System.out.println("6. Contact Number");
    System.out.println("7. Email");
    System.out.println("8. Address");
    System.out.println("9. Back");

    System.out.println("Choose: ");
    int choice;

    try{
    choice = Integer.parseInt(sc.nextLine().trim());
    } catch (NumberFormatException invalidPick){
        System.out.println("Invalid input. (1-9) only");
        return;
    }

    switch (choice){
        case 1:
            guyToEdit.setFirstName(readName("Enter new first name: "));
            System.out.println("First name updated.");
            break;
        case 2:
            guyToEdit.setMiddleName(readName("Enter new middle name: "));
            System.out.println("Middle name updated.");
            break;
        case 3:
            guyToEdit.setLastName(readName("Enter new last name: "));
            System.out.println("Last name updated.");
            break;
        case 4:
            System.out.println("Enter new gender: ");
            guyToEdit.setGender(sc.nextLine().trim());
            System.out.println("Gender updated.");
            break;
        case 5:
            guyToEdit.setBday(readBday());
            System.out.println("Birthday updated.");
            break;
        case 6:
            guyToEdit.setContactNumber(readContact());
            System.out.println("Contact number updated.");
            break;
        case 7:
            guyToEdit.setEmail(readEmail());
            System.out.println("Email updated.");
            break;
        case 8:
            System.out.println("Enter new address: ");
            guyToEdit.setAddress(sc.nextLine().trim());
            System.out.println("Address updated.");
            break;
        case 9:
            System.out.println("Returning to main menu");
            break;
        default:
            System.out.println("Invalid input. (1-9) only");
            break;
        }
    }

    private void removeGuy(){
    System.out.println("Borrower Id: ");
    String id = sc.nextLine().trim();

    if (id.isEmpty()){
        System.out.println("Invalid, blank Id");
        return;
    }
    
    ThisGuy guyToRemove = myGuys.checkMyGuy(id);
    if (myDealer.hasActiveDeal(guyToRemove)){
        System.out.println("Can not remove borrower");
        System.out.println("Still has unreturned material");
        return;
    }
    if (myGuys.eraseMyGuy(id)){
        System.out.println("Borrower removed");
    }
    else{
        System.out.println("No borrower matching Id");
        return;
    }

    }

    private void viewGuy(){
    System.out.println("Borrower Id: ");
    String id = sc.nextLine().trim();

    ThisGuy guyToFind = myGuys.checkMyGuy(id);

    if (id.isEmpty()){
        System.out.println("Invalid, blank Id");
        return;
    }
    if (guyToFind == null){
        System.out.println("No borrower matching Id");
        return;
    }
    showTheGuy(guyToFind);
    }

    private void viewAllGuys(){
        List<ThisGuy> allGuys = myGuys.getMyGuys();
        if (allGuys.isEmpty()){
            System.out.println("No borrowers yet.");
            return;
        }
        for (ThisGuy someDude : allGuys){
            showTheGuy(someDude);
        }
    }


    
    private void showTheGuy(ThisGuy thisGuyToFind){
        System.out.println("---Borrower Details---");
        System.out.println("Borrower Id: " + thisGuyToFind.getGuyId());
        System.out.println("Name: " + thisGuyToFind.getFirstName() + " " + thisGuyToFind.getMiddleName() + " " + thisGuyToFind.getLastName());
        System.out.println("Gender: " + thisGuyToFind.getGender());
        System.out.println("Birthday: " + thisGuyToFind.getBday());
        System.out.println("Contact Number: " + thisGuyToFind.getContactNumber());
        System.out.println("Email: " + thisGuyToFind.getEmail());
        System.out.println("Address: " + thisGuyToFind.getAddress());
        System.out.println("Strikes: " + thisGuyToFind.getStrikes());
    }

    private String readName(String prompt){
        String name;
        do {
        System.out.println(prompt);
        name = sc.nextLine().trim();
        if (!CheckHomie.isValidName(name)){
            System.out.println("Invalid name");
            System.out.println("(A-Zm,'-.) only");
            }
        }while(!CheckHomie.isValidName(name));
        return name;
    }

    private String readBday(){
        String bday;

        do{
        System.out.println("Enter birthday (YYYY-MM-DD): ");
        bday = sc.nextLine().trim();
        if (!CheckHomie.isValidBday(bday)){
            System.out.println("Invalid birthday");
            System.out.println("(YYYY-MM-DD) only");
            }
        }while(!CheckHomie.isValidBday(bday));
        return bday;
    }

    private String readContact(){
        String contact;

        do{
        System.out.println("Enter contact number (09XXXXXXXXX): ");
        contact = sc.nextLine().trim();
        if (!CheckHomie.isValidContact(contact)){
            System.out.println("Invalid contact number");
            System.out.println("(09XXXXXXXXX) only");
            }
        }while(!CheckHomie.isValidContact(contact));
        return contact;
    }   

    private String readEmail(){
        String email;

        do{
        System.out.println("Enter email: ");
        email = sc.nextLine().trim();
        if (!CheckHomie.isValidEmail(email)){
            System.out.println("Invalid email");
            System.out.println("(email@mail.ph) format only");
        } 
        }while(!CheckHomie.isValidEmail(email));
        return email;
    }
    }