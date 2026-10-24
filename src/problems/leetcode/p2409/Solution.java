package problems.leetcode.p2409;

class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] months = new int[] {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};

        int[] aliceArrive = parse(arriveAlice);
        int[] aliceLeave = parse(leaveAlice);
        int[] bobArrive = parse(arriveBob);
        int[] bobLeave = parse(leaveBob);

        int start = Math.max(months[aliceArrive[0] - 1] + aliceArrive[1], months[bobArrive[0] - 1] + bobArrive[1]);
        int end = Math.min(months[aliceLeave[0] - 1] + aliceLeave[1], months[bobLeave[0] - 1] + bobLeave[1]);

        if (start > end) {
            return 0;
        }

        return end - start + 1;
    }

    private int[] parse(String date) {
        int month = (date.charAt(0) - '0') * 10 + date.charAt(1) - '0';
        int day = (date.charAt(3) - '0') * 10 + date.charAt(4) - '0';
        return new int[] { month, day };
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countDaysTogether("10-01", "10-31", "11-01", "12-31"));
        System.out.println(new Solution().countDaysTogether("08-15", "08-18", "08-16", "08-19"));
    }
}