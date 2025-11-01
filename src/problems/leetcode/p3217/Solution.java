package problems.leetcode.p3217;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        boolean[] hasNums = new boolean[100_001];
        for (int num : nums) hasNums[num] = true;
        return f(hasNums, head);
    }

    private ListNode f(boolean[] hasNums, ListNode head) {
        if (head == null) return null;
        head.next = f(hasNums, head.next);
        if (hasNums[head.val]) return head.next;
        return head;
    }
}