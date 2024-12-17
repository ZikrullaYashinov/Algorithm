package leetcode;

import java.util.ArrayList;
import java.util.List;

class TrieNode {
    public boolean isEnd;
    public TrieNode[] children;

    public TrieNode() {
        isEnd = false;
        children = new TrieNode[26];
    }
}

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

public class P212 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();

        Trie trie = new Trie();
        for (String word : words)
            trie.insert(word);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                dfs(trie.root, visited, i, j, ans, board, "");
            }
        }

        return ans;
    }

    private void dfs(TrieNode node, boolean[][] visited, int i, int j, List<String> ans, char[][] board, String word) {
        if (!(0 <= i && i < visited.length && 0 <= j && j < visited[0].length) || visited[i][j]) return;
        char c = board[i][j];
        visited[i][j] = true;
        if (node.children[c - 'a'] != null) {
            word += c;
            if (node.children[c - 'a'].isEnd) {
                ans.add(word);
                node.children[c - 'a'].isEnd = false;
            }
            dfs(node.children[c - 'a'], visited, i - 1, j, ans, board, word);
            dfs(node.children[c - 'a'], visited, i + 1, j, ans, board, word);
            dfs(node.children[c - 'a'], visited, i, j - 1, ans, board, word);
            dfs(node.children[c - 'a'], visited, i, j + 1, ans, board, word);
        }
        visited[i][j] = false;
    }

    public static void main(String[] args) {
        System.out.println(new P212().findWords(
                new char[][]{
                        {'o', 'a', 'a', 'n'},
                        {'e', 't', 'a', 'e'},
                        {'i', 'h', 'k', 'r'},
                        {'i', 'f', 'l', 'v'}
                },
                new String[]{"oath", "pea", "eat", "rain", "hklf", "hf"}));
    }
}