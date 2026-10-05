package problems.leetcode.p1111;

class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] arr = new int[seq.length()];
        int i = seq.indexOf("()");
        arr[i] = 1;
        arr[i + 1] = 1;
        int j = seq.indexOf("()", i + 1);
        arr[j] = 1;
        arr[j + 1] = 1;
        return arr;
    }
}