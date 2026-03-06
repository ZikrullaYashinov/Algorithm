package problems.leetcode.p1784;

class Solution {
    public boolean checkOnesSegment(String s) {
        byte[] bytes = s.getBytes();

        boolean ones = false;
        byte last = bytes[0];
        for (byte aByte : bytes) {
            if (aByte == '1') {
                if (ones && last == '0') {
                    return false;
                }
                ones = true;
            }
            last = aByte;
        }
        return true;
    }

    static void main() {
        Solution solution = new Solution();
        System.out.println(solution.checkOnesSegment("1001"));
    }
}