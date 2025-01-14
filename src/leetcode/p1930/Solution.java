package leetcode.p1930;

class Solution {
    public int countPalindromicSubsequence(String s) {
        int count = 0;
        byte[] bytes = s.getBytes();
        for (byte i = 'a'; i <= 'z'; i++) {
            int startIndex = s.indexOf(i)+1;
            int endIndex = s.lastIndexOf(i);
            int[] arr = new int[26];
            for (int j = startIndex; j < endIndex; j++)
                arr[bytes[j] - 'a'] = 1;
            for (int b : arr)
                count += b;
        }
        return count;
    }
}