package problems.leetcode.p3042;

class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0, n = words.length;
        for (int i = 0; i < n; i++) {
            String word1 = words[i];
            for (int j = i + 1; j < n; j++) {
                String word2 = words[j];
                if (word2.startsWith(word1) && word2.endsWith(word1))
                    count++;
            }
        }        
        return count;
    }
}