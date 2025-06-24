package leetcodecontests.practise.q1;

class Solution {
    public boolean checkPrimeFrequency(int[] nums) {
        int[] primes = new int[101];

        for (int j : nums)
            primes[j]++;

        for (int i = 0; i < 101; i++) {
            int num = primes[i];
            if (prime(num))
                return true;
        }
        return false;
    }

    boolean prime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= (int) Math.pow(num, 0.5); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkPrimeFrequency(new int[]{1, 2, 3, 4, 5, 4}));
    }
}