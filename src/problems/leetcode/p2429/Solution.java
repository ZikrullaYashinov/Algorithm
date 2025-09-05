package problems.leetcode.p2429;

class Solution {
    public int minimizeXor(int num1, int num2) {
        int bitCount = Integer.bitCount(num2);
        byte[] arr = Integer.toBinaryString(num1).getBytes();
        byte[] arr2 = arr;

        for (int i = 0; i < arr.length && bitCount > 0; i++) {
            if (arr[i] == '1') {
                arr2[i] = 1;
                bitCount--;
            }
        }

        for (int i = arr.length - 1; i >= 0 && bitCount > 0; i--) {
            if (arr[i] == '0') {
                arr2[i] = '1';
                bitCount--;
            }
        }

        int result = 0;
        int m = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == '1') {
                result += m;
            }
            m <<= 1;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimizeXor(3, 5));
    }
}