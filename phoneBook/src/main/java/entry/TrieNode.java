package entry;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;
    Contact contact;

    public TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
        contact = null;
    }
}
