package problems.leetcode.p1408;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private boolean hasWord(String[] words, int n, String word, int index) {
        for (int i = 0; i < n; i++)
            if (index != i && words[i].contains(word))
                return true;
        return false;
    }

    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        int n = words.length;
        for (int i = 0; i < n; i++)
            if (hasWord(words, n, words[i], i))
                res.add(words[i]);
        return res;
    }
}