package problems.leetcode.p2095;

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
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) return null;

        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }

        int middle = (length) / 2;
        cur = head;
        ListNode res = new ListNode(cur.val);
        ListNode temp = res;
        for (int i = 1; i < length; i++) {
            cur = cur.next;
            if (i != middle && cur != null) {
                temp.next = new ListNode(cur.val);
                temp = temp.next;
            }
        }
        return res;
    }
}

class Main {
    void main(String[] args) {
        new Solution().deleteMiddle(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7))))))));
    }
}