//package problems.leetcode.p3440
//
//class SolutionKotlin {
//    fun maxFreeTime(eventTime: Int, startTime: IntArray, endTime: IntArray): Int {
//         var time = 0
//        val n = startTime.size;
//
//        val arr = IntArray(n + 1)
//        val arrItems = IntArray(n)
//
//        for (i in 0 until n) {
//            arr[i] = startTime[i] - time
//            arrItems[i] = endTime[i] - startTime[i]
//            time = endTime[i]
//        }
//
//        arr[n] = eventTime - endTime[n - 1]
//
//        for (i in 0 until n) {
//
//        }
//
//        var sum = 0
//        for (i in 0 until k) {
//            sum += arr[i]
//        }
//
//        var maxSum = 0
//        for (i in k until n + 1) {
//            sum += arr[i]
//            if (sum > maxSum) maxSum = sum
//            sum -= arr[i - k]
//        }
//
//        return maxSum
//    }
//}