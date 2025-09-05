package problems.leetcode.p2264;

class Solution {
    public String largestGoodInteger(String num) {
        byte last = 0;
        byte max = 0;
        int count = 0;

        for (byte b : num.getBytes()) {
            if (last == b) {
                count++;
            } else {
                if (count >= 3 && last > max)
                    max = last;
                count = 1;
                last = b;
            }
        }
        if (count >= 3 && last > max)
            max = last;

        if (max == 0) return "";

        return String.valueOf((char) max).repeat(3);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestGoodInteger("42352338"));
        System.out.println(solution.largestGoodInteger("2300019"));
        System.out.println(solution.largestGoodInteger("6777133339"));
    }
}