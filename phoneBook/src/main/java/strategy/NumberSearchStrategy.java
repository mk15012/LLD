package strategy;

import entry.Contact;
import entry.Trie;

import java.util.List;


public class NumberSearchStrategy implements SearchStrategy {

    @Override
    public List<Contact> search(Trie trie, String query) {
        return trie.searchByPrefix(query);
    }
}
