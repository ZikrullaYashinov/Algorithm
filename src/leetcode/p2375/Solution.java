package leetcode.p2375;

class Solution {
    public String smallestNumber(String pattern) {
        int n = pattern.length();
        int[] arr = new int[n + 1];
        int j = -1;
        int num = 1;

        for (int i = 0; i < n; i++) {
            if (pattern.charAt(i) == 'I') {
                arr[i] = num++;
                if (j != -1) {
                    for (int k = i - 1; k >= j; k--)
                        arr[k] = num++;
                    j = -1;
                }
            } else if (j == -1)
                j = i;
        }

        if (j != -1)
            for (int k = n; k >= j; k--)
                arr[k] = num++;
        else
            arr[n] = num;

        StringBuilder sb = new StringBuilder();
        for (int s : arr)
            sb.append(s);

        return sb.toString();
    }
}