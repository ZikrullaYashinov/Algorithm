package problems.leetcode.p1266;

class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int[] last = points[0];
        int time = 0;
        for (int i = 1; i < points.length; i++) {
            int[] current = points[i];
            time += Math.max(Math.abs(last[0] - current[0]), Math.abs(last[1] - current[1]));
            last = current;
        }
        return time;
    }
}