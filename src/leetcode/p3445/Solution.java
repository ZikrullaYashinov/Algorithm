package leetcode.p3445;

class Solution {
    public int maxDifference(String s, int k) {
        byte[] bytes = s.getBytes();
        int n = bytes.length;
        int[] arr = new int[5];
        int maxOdd;
        int minEven;
        int res = Integer.MIN_VALUE;

        int left = 0, right = 0;
        while (left <= right && right <= n) {
            maxOdd = max(arr);
            minEven = min(arr);

            if (maxOdd > 0 && minEven > 0 && maxOdd - minEven > res)
                res = maxOdd - minEven;

            if (maxOdd >= minEven) {
                byte b = bytes[right++];
                arr[b - '0']++;
            } else {
                byte b = bytes[left++];
                arr[b - '0']--;
            }
        }

        return res;
    }

    int min(int[] arr) {
        int b = 5;
        for (int i = 0; i < 5; i++) {
            if (arr[i] < b && arr[i] % 2 == 0 && arr[i] != 0) {
                b = arr[i];
            }
        }
        return b;
    }

    int max(int[] arr) {
        int b = 0;
        for (int i = 0; i < 5; i++) {
            if (arr[i] > b && arr[i] % 2 == 1) {
                b = arr[i];
            }
        }
        return b;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxDifference("12233", 4));
    }
}