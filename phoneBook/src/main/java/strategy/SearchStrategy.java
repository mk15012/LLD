package strategy;

import entry.Contact;
import entry.Trie;

import java.util.List;

public interface SearchStrategy {
    List<Contact> search(Trie trie, String query);
}
