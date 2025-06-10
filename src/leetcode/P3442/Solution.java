package leetcode.P3442;

class Solution {
    public int maxDifference(String s) {
        byte[] arr = new byte[26];
        int n = s.length();

        for (int i = 0; i < n; i++) {
            arr[s.charAt(i) - 'a']++;
        }

        int min = 101;
        int max = 0;

        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) {
                if (arr[i] % 2 == 1 && arr[i] > max) {
                    max = arr[i];
                }
                if (arr[i] % 2 == 0 && arr[i] < min) {
                    min = arr[i];
                }
            }
        }

        return max - min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxDifference("aaaaabbc"));
    }
}