package problems.leetcode.p0165;

class Solution {
    public int compareVersion(String version1, String version2) {
        String[] version1Parts = version1.split("\\.");
        String[] version2Parts = version2.split("\\.");

        int n1 = version1Parts.length;
        int n2 = version2Parts.length;

        int min = Math.min(n1, n2);
        for (int i = 0; i < min; i++) {
            int num1 = Integer.parseInt(version1Parts[i]);
            int num2 = Integer.parseInt(version2Parts[i]);
            
            if (num1 > num2)
                return 1;

            if (num1 < num2)
                return -1;
        }

        for (int i = min; i < n1; i++) {
            int num = Integer.parseInt(version1Parts[i]);
            if (num > 0)
                return 1;
        }
        

        for (int i = min; i < n2; i++) {
            int num = Integer.parseInt(version2Parts[i]);
            if (num > 0)
                return -1;
        }

        return 0;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.compareVersion("1.2", "1.10"));
    }
}