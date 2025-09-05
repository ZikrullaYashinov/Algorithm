package problems.leetcode.p2349;

import java.util.*;

class NumberContainers {

    Map<Integer, Set<Integer>> map;
    Map<Integer, Integer> nums;

    public NumberContainers() {
        map = new HashMap<>();
        nums = new HashMap<>();
    }

    Set<Integer> set;
    Integer val;
    
    public void change(int index, int number) {
        val = nums.get(index);
        if (val != null) {
            set = map.get(val);
            if (set != null) {
                set.remove(index);
            }
        }
        nums.put(index, number);
        set = map.getOrDefault(number, new TreeSet<>());
        set.add(index);
        map.put(number, set);
    }

    Iterator<Integer> iterator;
    public int find(int number) {
        set = map.get(number);
        if (set == null) {
            return -1;
        }
        iterator = set.iterator();
        if (iterator.hasNext()) {
            return iterator.next();
        }
        return -1;
    }

    public static void main(String[] args) {
        NumberContainers numberContainers = new NumberContainers();
        numberContainers.find(10);
        numberContainers.change(2, 10);
        numberContainers.change(1, 10);
        numberContainers.change(3, 10);
        numberContainers.change(5, 10);
        numberContainers.find(10);
        numberContainers.change(1, 20);

    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */