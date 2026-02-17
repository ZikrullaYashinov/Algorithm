package problems.leetcode.p3713;

class Solution {
    public int longestBalanced(String s) {
        char[] chars = s.toCharArray();
        for (int i = chars.length; i > 0; i--) {
            for (int j = 0; j <= chars.length - i; j++) {
                if (isValid(chars, j, j + i)) {
                    return i;
                }
            }
        }
        return 0;
    }

    private boolean isValid(char[] chars, int begin, int end) {
        int[] arr = new int[26];
        for (int i = begin; i < end; i++) {
            arr[chars[i] - 'a']++;
        }
        int count = arr[0];
        for (int i : arr) {
            if (i > 0) {
                if (count == 0) {
                    count = i;
                } else if (i != count) {
                    return false;
                }
            }
        }
        return true;
    }

    static void main() {
        Solution solution = new Solution();
        System.out.println(solution.longestBalanced("f"));
        System.out.println(solution.longestBalanced("abbac"));
        System.out.println(solution.longestBalanced("zzabccy"));
        System.out.println(solution.longestBalanced("aba"));
    }
}