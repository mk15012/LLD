import entry.Contact;
import manager.ContactManager;
import strategy.SearchFactory;
import strategy.SearchStrategy;

import java.util.Scanner;

public class Phonebook {
    private ContactManager contactManager;
    private Scanner scanner;

    public Phonebook() {
        contactManager = new ContactManager();
        scanner = new Scanner(System.in);
    }

    public void showMenu() {
        System.out.println("\nPhonebook Menu:");
        System.out.println("1. Add Contact");
        System.out.println("2. View All Contacts");
        System.out.println("3. Search Contact by Name");
        System.out.println("4. Search Contact by Number");
        System.out.println("5. Delete Contact");
        System.out.println("6. Update Contact");
        System.out.println("7. Exit");
        System.out.print("Choose an option: ");
    }

    public void run() {
        boolean exit = false;

        while (!exit) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    searchContact("name");
                    break;
                case 4:
                    searchContact("number");
                    break;
                case 5:
                    deleteContact();
                    break;
                case 6:
                    updateContact();
                    break;
                case 7:
                    exit = true;
                    System.out.println("Exiting Phonebook...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addContact() {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();
        contactManager.addContact(new Contact(name, phoneNumber));
        System.out.println("Contact added successfully.");
    }

    private void viewContacts() {
        contactManager.viewAllContacts();
    }

    private void searchContact(String searchType) {
        System.out.print("Enter " + (searchType.equals("name") ? "Name" : "Phone Number") + " to Search: ");
        String input = scanner.nextLine();
        SearchStrategy searchStrategy = SearchFactory.getSearchStrategy(searchType);
        contactManager.searchContact(searchStrategy, input);
    }

    private void deleteContact() {
        System.out.print("Enter Name to Delete: ");
        String name = scanner.nextLine();
        contactManager.deleteContact(name);
    }

    private void updateContact() {
        System.out.print("Enter Name to Update: ");
        String name = scanner.nextLine();
        System.out.print("Enter New Phone Number: ");
        String newPhoneNumber = scanner.nextLine();
        contactManager.updateContact(name, newPhoneNumber);
    }

    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        phonebook.run();
    }
}
