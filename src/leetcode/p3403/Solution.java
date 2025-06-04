package leetcode.p3403;

class Solution {
    public String answerString(String word, int numFriends) {
        if (numFriends == 1) return word;

        int n = word.length();

        char max = word.charAt(0);
        int maxIndex = 0;

        for (int i = 1; i < n; i++) {
            if (word.charAt(i) > max) {
                max = word.charAt(i);
                maxIndex = i;
            }
        }

        int index = word.indexOf(max);
        while (index != -1) {
            if (word.substring(maxIndex).compareTo(word.substring(index)) < 0) {
                maxIndex = index;
            }
            index = word.indexOf(max, index + 1);
        }

        return word.substring(maxIndex, Math.min(n, maxIndex + n - numFriends + 1));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.answerString("aann", 2));
        System.out.println(solution.answerString("aann", 4));
        System.out.println(solution.answerString("gh", 1));
        System.out.println(solution.answerString("dbca", 2));
        System.out.println(solution.answerString("gggg", 4));
    }
}