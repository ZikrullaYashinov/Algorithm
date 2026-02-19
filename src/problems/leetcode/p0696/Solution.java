package problems.leetcode.p0696;

class Solution {
    public int countBinarySubstrings(String s) {
        byte[] bytes = s.getBytes();

        byte last = bytes[0];

        int zerosCount = 0;
        int onesCount = 0;

        if (last == '1')
            onesCount++;
        else
            zerosCount++;

        int result = 0;
        for (int i = 1; i < s.length(); i++) {
            byte b = bytes[i];
            if (b == '0') {
                if (last != '0') {
                    result += Math.min(zerosCount, onesCount);
                    zerosCount = 0;
                }
                zerosCount++;
            } else {
                if (last != '1') {
                    result += Math.min(zerosCount, onesCount);
                    onesCount = 0;
                }
                onesCount++;
            }

            last = b;
        }
        return result + Math.min(zerosCount, onesCount);
    }

    static void main() {
        Solution solution = new Solution();
        System.out.println(solution.countBinarySubstrings("1011"));
    }
}