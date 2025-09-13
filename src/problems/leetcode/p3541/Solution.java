package problems.leetcode.p3541;

class Solution {
    public int maxFreqSum(String s) {
        int[] counts = new int[26];
        for (char ch : s.toCharArray()) {
            counts[ch - 'a']++;
        }

        char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};
        int maxVowelCount = 0, maxConsonantCount = 0;
        for (int i = 0; i < 26; i++) {
            if (contains(vowels, i)) {
                if (counts[i] > maxVowelCount)
                    maxVowelCount = counts[i];
            } else if (counts[i] > maxConsonantCount)
                maxConsonantCount = counts[i];
        }
        return maxVowelCount + maxConsonantCount;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxFreqSum("successes"));
    }

    private boolean contains(char[] vowels, int key) {
        for (char vowel : vowels)
            if (vowel - 'a' == key)
                return true;
        return false;
    }
}