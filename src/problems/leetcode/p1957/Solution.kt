package problems.leetcode.p1957

class Solution {
    fun makeFancyString(s: String): String {
        val charArray = s.toCharArray()
        val sb = StringBuilder()

        var last = charArray[0]
        var count = 1
        sb.append(last)

        for (i in 1..charArray.size - 1) {
            if (last != charArray[i]) {
                count = 1
                last = charArray[i]
            } else
                count++
            if (count < 3)
                sb.append(last)
        }

        return sb.toString()
    }
}

fun main() {
    println(Solution().makeFancyString("leeetcode"))
}