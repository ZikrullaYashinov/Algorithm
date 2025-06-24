package leetcode.p3085;

import java.util.Arrays;
import java.util.Map;

class Solution {
    public int minimumDeletions(String word, int k) {
        int[] arr = new int[26];

        for (int i = 0; i < word.length(); i++) {
            arr[word.charAt(i) - 'a']++;
        }

        Arrays.sort(arr);

        int leftIndex = 0, left = 0;
        int rightIndex = 0, right;

        int sum = 0;
        boolean a = true;
        for (int i = 0; i < 26; i++) {
            sum += arr[i];
            if (a && arr[i] != 0) {
                a = false;
                leftIndex = i;
                rightIndex = i;
                left = arr[leftIndex];
            }
        }

        int curSum = 0;
        int res = sum;

        while (rightIndex < 26) {
            right = arr[rightIndex];

            if (right - left <= k) {
                curSum += right;
                rightIndex++;
            } else {
                int remainSum = sum - curSum - (26 - rightIndex) * (left + k);
                if (remainSum < res) res = remainSum;
                curSum -= left;
                left = arr[++leftIndex];
            }
        }

        int remainSum = sum - curSum;
        if (remainSum < res) res = remainSum;

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumDeletions("athfqpwyxzhxxsberakrbfhnpmysahyncficmfebbxldcxpwaumtvoxndfkyrcbavrpghvslwsajnrmycjdxcskrouqmnnfsxbholyhwufkfagmipyimtubqalhimuavjanunenyaziqhhpdbxujkvbtkektopprhcjlvaqxtedbgjdbpudvxkurbmmsypfbdnbomibtwyhlvvyyrnwqzcetnqvgvmsxoybpyltniyjbtga", 7));
        System.out.println(solution.minimumDeletions("ahahnhahhah", 1));
        System.out.println(solution.minimumDeletions("aabcaba", 0));
        System.out.println(solution.minimumDeletions("dabdcbdcdcd", 2));
        System.out.println(solution.minimumDeletions("aaabaaa", 2));
    }
}