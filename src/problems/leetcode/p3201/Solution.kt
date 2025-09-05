package problems.leetcode.p3201

import kotlin.math.max

class Solution {
    fun maximumLength(nums: IntArray): Int {
        if (nums.size <= 2) return nums.size
        var oddCount = 0
        var evenCount = 0
        var mixCount = 0
        for (i in nums) {
            if (i % 2 == 0) evenCount++
            else oddCount++
        }

        var last = nums[0] % 2
        for (i in 1..nums.size - 1) {
            if (last != nums[i] % 2) {
                last = 1 - last
                mixCount++
            }
        }

        return max(max(evenCount, oddCount), mixCount + 1)
    }
}