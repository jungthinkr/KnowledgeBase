package structures;

// Prefix tree that stores words

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Trie {
    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    private TrieNode parent = new TrieNode();

    public void addWord(String word) {
        TrieNode curr = parent;
        for (int i=0;i<word.length();i++) {
            char c = word.charAt(i);
            if (curr.children[c-'a'] == null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }

    public boolean findExists(String word) {
        TrieNode curr = parent;
        for (int i=0;i<word.length();i++) {
            char c = word.charAt(i);
            if (curr.children[c-'a'] == null) return false;
            curr = curr.children[c-'a'];
        }
        return curr.isEnd;
    }

    public List<String> find(String prefix) {
        TrieNode curr = parent;

        for (int i=0;i<prefix.length();i++) {
            char c = prefix.charAt(i);
            if (curr.children[c-'a'] == null) return Collections.emptyList();
            curr = curr.children[c-'a'];
        }

        List<String> collection = new ArrayList<>();
        find(curr, collection, prefix);
        return collection;
    }


    private void find(TrieNode curr, List<String> collection, String prefix) {
        if (curr == null) return;
        for (int i=0;i<curr.children.length;i++) {
            TrieNode node = curr.children[i];
            if (node != null) {
                if (node.isEnd) {
                    collection.add(prefix + (char) (i+'a'));
                }
                find(node, collection, prefix + (char) (i+'a'));
            }
        }
    }
}
