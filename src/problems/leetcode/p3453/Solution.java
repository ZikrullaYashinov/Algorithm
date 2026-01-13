package problems.leetcode.p3453;

class Solution {

    static void main() {
        Solution solution = new Solution();
//        int[][] points = new int[][]{{0, 0, 1}, {2, 2, 1}};
//        int[][] points = new int[][]{{0, 0, 2}, {1, 1, 1}};
        int[][] points = new int[][]{{522261215,954313664,225462},{628661372,718610752,10667},{619734768,941310679,44788},{352367502,656774918,289036},{860247066,905800565,100123},{817623994,962847576,71460},{691552058,782740602,36271},{911356,152015365,513881},{462847044,859151855,233567},{672324240,954509294,685569}};
        System.out.println(solution.separateSquares(points));
    }

    public double separateSquares(int[][] squares) {
        double min = Double.MAX_VALUE;
        double max = -Double.MAX_VALUE;

        for (int[] square : squares) {
            if (square[1] < min) min = square[1];
            if (square[1] + square[2] > max) max = square[1] + square[2];
        }

        double predictY = (min + max) / 2;
        double res = separateEqual(squares, predictY);

        while (Math.abs(max - min) >= 1e-5) {

            if (res > 0) {
                min = predictY;
            } else {
                max = predictY;
            }

            predictY = (min + max) / 2;
            res = separateEqual(squares, predictY);
        }

        return predictY;
    }

    private double round(double value) {
        return Math.round(value * 100_000) / 100_000.0;
    }

    public double separateEqual(int[][] squares, double y) {
        double sum = 0;
        for (int[] square : squares) {
            sum += calculateArea(square, y);
        }
        return sum;
    }

    private double calculateArea(int[] square, double sy) {
        int y = square[1];
        int l = square[2];

        if (y >= sy) return l * l;
        if (y + l <= sy) return -l * l;
        return (2 * y - 2 * sy + l) * l;
    }
}