package problems.leetcode.p3047;

class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long maxSide = 0;
        for (int i = 0; i < bottomLeft.length; i++) {
            for (int j = i + 1; j < bottomLeft.length; j++) {
                int side = intersectingSide(bottomLeft[i], topRight[i], bottomLeft[j], topRight[j]);
                if (side > maxSide) {
                    maxSide = side;
                }
            }
        }
        return maxSide * maxSide;
    }

    private int intersectingSide(int[] bottomLeft1, int[] topRight1, int[] bottomLeft2, int[] topRight2) {
        return Math.min(
                Math.max(Math.min(topRight1[0], topRight2[0]) - Math.max(bottomLeft1[0], bottomLeft2[0]), 0),
                Math.max(Math.min(topRight1[1], topRight2[1]) - Math.max(bottomLeft1[1], bottomLeft2[1]), 0)
        );
    }
}