package algorithm;

class TrieNode {
    public boolean isEnd;
    public TrieNode[] next;

    public TrieNode() {
        isEnd = false;
        next = new TrieNode[256];
    }
}

class Trie {
    public TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (temp.next[c] == null)
                temp.next[c] = new TrieNode();
            temp = temp.next[c];
        }
        temp.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (temp.next[c] == null)
                return false;
            temp = temp.next[c];
        }
        return temp.isEnd;
    }

    public void delete(String word) {
        root = delete(root, word, 0);
    }

    private TrieNode delete(TrieNode node, String word, int step) {
        if (node == null)
            return null;
        if (step == word.length()) {
            node.isEnd = false;
            if (isEmpty(node))
                node = null;
            return node;
        }
        char c = word.charAt(step);
        node.next[c] = delete(node.next[c], word, step + 1);
        return node;
    }

    private boolean isEmpty(TrieNode node) {
        for (int i = 0; i < node.next.length; i++)
            if (node.next[i] != null)
                return false;
        return true;
    }

}

public class TrieDataStructure {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("Salom");
        System.out.println(trie.search("Salom"));
        trie.delete("Salom");
        System.out.println(trie.search("Salom"));
    }
}
