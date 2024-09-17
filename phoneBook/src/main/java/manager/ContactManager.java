package manager;

import entry.Contact;
import entry.Trie;
import strategy.NameSearchStrategy;
import strategy.SearchStrategy;

import java.util.List;

public class ContactManager {
    private Trie nameTrie;
    private Trie numberTrie;

    public ContactManager() {
        nameTrie = new Trie();
        numberTrie = new Trie();
    }

    public void addContact(Contact contact) {
        nameTrie.insert(contact.getName(), contact);
        numberTrie.insert(contact.getPhoneNumber(), contact);
    }

    public void viewAllContacts() {
        List<Contact> contacts = nameTrie.searchByPrefix("");
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    public void searchContact(SearchStrategy strategy, String query) {
        Trie trie = (strategy instanceof NameSearchStrategy) ? nameTrie : numberTrie;
        List<Contact> contacts = strategy.search(trie, query);
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    public void deleteContact(String name) {
        System.out.println("Deletion is not implemented yet.");
    }

    public void updateContact(String name, String newPhoneNumber) {
        List<Contact> contacts = nameTrie.searchByPrefix(name.toLowerCase());
        if (!contacts.isEmpty()) {
            Contact contact = contacts.get(0);  // Assuming unique names
            deleteContact(contact.getName());
            contact.setPhoneNumber(newPhoneNumber);
            addContact(contact);
            System.out.println("Contact updated successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }
}
