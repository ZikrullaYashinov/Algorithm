package leetcode.p212;

class TrieNode {
    public boolean isEnd;
    public TrieNode[] children;

    public TrieNode() {
        isEnd = false;
        children = new TrieNode[26];
    }
}