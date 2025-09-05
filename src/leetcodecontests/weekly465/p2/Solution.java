package leetcodecontests.weekly465.p2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] minDifference(int n, int k) {
        List<Integer> divisors = new ArrayList<>();
        int div = 2;
        while (n > 1) {
            if (n % div == 0) {
                divisors.add(div);
                n /= div;
            } else div++;
        }

        if (divisors.size() > k)
            divisors = find(divisors, k);
        else{
            for (int i = divisors.size(); i < k; i++) {
                divisors.add(1);
            }
            Collections.sort(divisors);
        }

        int[] res = new int[k];
        for (int i = 0; i < divisors.size(); i++) {
            res[i] = divisors.get(i);
        }

        return res;
    }

    private List<Integer> find(List<Integer> divisors, int k) {
        if (divisors.size() == k) {
            return divisors;
        }

        List<Integer> copy = new ArrayList<>(divisors);
        Collections.sort(copy);
        Integer first = copy.getFirst();
        copy.remove(first);

        int distance = -1;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < copy.size(); i++) {
            Integer item = copy.get(i);
            copy.set(i, item * first);
            List<Integer> integerList = find(copy, k);
            Collections.sort(integerList);
            int newDis = integerList.getLast() - integerList.getFirst();
            if (distance == -1 || newDis < distance) {
                distance = newDis;
                res = new ArrayList<>(integerList);
            }
            copy.set(i, item);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().minDifference(18, 5)));
        System.out.println(Arrays.toString(new Solution().minDifference(100, 2)));
        System.out.println(Arrays.toString(new Solution().minDifference(44, 3)));
    }
}