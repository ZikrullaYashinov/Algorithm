package problems.leetcode.p0120;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        List<Integer> lastRow = triangle.get(0);
        for (int i = 1; i < n; i++) {
            List<Integer> child = new ArrayList<>(triangle.get(i));
            int m = child.size();
            for (int j = 0; j < m; j++) {
                int temp = Integer.MAX_VALUE;
                if (j < m - 1 && temp > lastRow.get(j))
                    temp = lastRow.get(j);
                if (j > 0 && temp > lastRow.get(j - 1))
                    temp = lastRow.get(j - 1);
                child.set(j, temp + child.get(j));
            }
            lastRow = child;
        }
        int min = Integer.MAX_VALUE;
        for (Integer i : lastRow)
            if (i < min)
                min = i;
        return min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(List.of(2));
        triangle.add(List.of(3, 4));
        triangle.add(List.of(6, 5, 7));
        triangle.add(List.of(4, 1, 8, 3));
        System.out.println(solution.minimumTotal(triangle));
    }
}