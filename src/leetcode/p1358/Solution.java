package leetcode.p1358;

class Solution {
    public int numberOfSubstrings(String s) {
        int start = 0, end = 3;
        byte[] bytes = s.getBytes();
        int n = bytes.length;
        int[] alphabet = new int[3];
        int count = 0;

        for (int i = start; i < end; i++) {
            alphabet[bytes[i] - 'a']++;
        }

        while (start < end) {
            if (isAll(alphabet)) {
                count += n - end + 1;
                alphabet[bytes[start] - 'a']--;
                start++;
            } else {
                if (end >= n) return count;
                alphabet[bytes[end] - 'a']++;
                end++;
            }
        }

        return count;
    }

    boolean isAll(int[] alphabet) {
        for (int i: alphabet) {
            if (i <= 0) {
                return false;
            }
        }
        return true;
    }
}
