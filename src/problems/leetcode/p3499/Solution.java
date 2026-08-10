//package problems.leetcode.p3499;
//
//class Solution {
//    public int maxActiveSectionsAfterTrade(String s) {
//        int[] counts = new int[s.length()];
//
//        char last = s.charAt(0);
//        int index = 0;
//        for (byte aByte : s.getBytes()) {
//            if (aByte == last) {
//                counts[index]++;
//            } else {
//                last = (char) aByte;
//                index++;
//            }
//        }
//
//        for (int i = 0; i < s.length(); i++) {
//
//        }
//
//    }
//
//    static void main() {
//        System.out.println(new Solution().maxActiveSectionsAfterTrade("01"));
//        System.out.println(new Solution().maxActiveSectionsAfterTrade("0100"));
//        System.out.println(new Solution().maxActiveSectionsAfterTrade("1000100"));
//    }
//}