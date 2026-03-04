//package problems.leetcode.p1404;
//
//class Solution {
//    public int numSteps(String s) {
//        int additionalSpaces = 5;
//        byte[] sBytes = s.getBytes();
//        byte[] bytes = new byte[sBytes.length + additionalSpaces];
//
//        for (int i = additionalSpaces; i < bytes.length; i++) {
//            bytes[i] = sBytes[i - additionalSpaces];
//        }
//
//        int step = 0;
//        int right = bytes.length - 1;
//        while () {
//            step++;
//            if (bytes[right] == '1') increase(bytes, right);
//            right--;
//        }
//        return step;
//    }
//
//    private void increase(byte[] bytes, int right) {
//        while (true) {
//            if (bytes[right] != '1') {
//                bytes[right] = '1';
//                return;
//            }
//            bytes[right--] = '0';
//        }
//    }
//
//    static void main() {
//        Solution solution = new Solution();
//        System.out.println(solution.numSteps("1101"));
//    }
//}