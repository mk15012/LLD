package entry;

import java.util.ArrayList;
import java.util.List;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String key, Contact contact) {
        TrieNode node = root;
        for (char ch : key.toLowerCase().toCharArray()) {
            node.children.putIfAbsent(ch, new TrieNode());
            node = node.children.get(ch);
        }
        node.isEndOfWord = true;
        node.contact = contact;
    }

    public List<Contact> searchByPrefix(String prefix) {
        TrieNode node = root;
        List<Contact> result = new ArrayList<>();
        for (char ch : prefix.toLowerCase().toCharArray()) {
            node = node.children.get(ch);
            if (node == null) {
                return result;
            }
        }
        findAllContacts(node, result);
        return result;
    }

    private void findAllContacts(TrieNode node, List<Contact> result) {
        if (node.isEndOfWord) {
            result.add(node.contact);
        }
        for (TrieNode child : node.children.values()) {
            findAllContacts(child, result);
        }
    }
}
