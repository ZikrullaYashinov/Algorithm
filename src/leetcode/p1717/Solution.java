package leetcode.p1717;

import java.util.Stack;

class Solution {
    public int maximumGain(String s, int x, int y) {
        Stack<Byte> stack = new Stack<>();
        boolean dominantX = x > y;
        byte[] bytes = s.getBytes();
        int sum = 0;
        for (byte b : bytes) {
            if (b != 'a' && b != 'b') {
                sum += sumNotDominant(stack, dominantX ? y : x);
            } else {
                boolean isPop = false;
                if (!stack.isEmpty()) {
                    byte peek = stack.peek();
                    if (dominantX && peek == 'a' && b == 'b') {
                        stack.pop();
                        sum += x;
                        isPop = true;
                    } else if (!dominantX && peek == 'b' && b == 'a') {
                        stack.pop();
                        sum += y;
                        isPop = true;
                    }
                }
                if (!isPop)
                    stack.add(b);
            }
        }
        sum += sumNotDominant(stack, dominantX ? y : x);
        return sum;
    }

    private int sumNotDominant(Stack<Byte> stack, int notDominant) {
        int countA = 0, countB = 0;
        while (!stack.isEmpty()) {
            byte cur = stack.pop();
            if (cur == 'a') countA++;
            else if (cur == 'b') countB++;
        }
        return Math.min(countA, countB) * notDominant;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumGain("cdbcbbaaabab", 4, 5));
    }
}