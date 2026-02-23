package problems.leetcode.p1461;

class Solution {
    public boolean hasAllCodes(String s, int k) {
        if (s.length() <= k) return false;

        boolean[] intent = new boolean[1 << k];

        byte[] bytes = s.getBytes();

        int cur = 0;
        for (int i = 0; i < k; i++) {
            cur = (cur << 1) + bytes[i] - '0';
        }
        intent[cur] = true;

        int killerNumber = k == 1 ? 0 : (1 << (k - 1)) - 1;

        for (int i = k; i < bytes.length; i++) {
            cur = ((cur & killerNumber) << 1) + bytes[i] - '0';
            intent[cur] = true;
        }

        for (boolean subIntent : intent) {
            if (!subIntent) {
                return false;
            }
        }
        return true;
    }

    static void main() {
        Solution solution = new Solution();
        System.out.println(solution.hasAllCodes("01100", 2));
        System.out.println(solution.hasAllCodes("0", 20));
        System.out.println(solution.hasAllCodes("00000000001011100", 3));
        System.out.println(solution.hasAllCodes("0110", 1));
        System.out.println(solution.hasAllCodes("00110110", 2));
    }
}