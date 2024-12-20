package leetcode.p212;

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (temp.children[c - 'a'] == null)
                temp.children[c - 'a'] = new TrieNode();
            temp = temp.children[c - 'a'];
        }
        temp.isEnd = true;
    }
}