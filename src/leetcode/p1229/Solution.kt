package leetcode.p1229

data class ListNode(
    var `val`: Int,
    var next: ListNode? = null
)

class Solution {
    fun getDecimalValue(head: ListNode?): Int {
        val list = mutableListOf<Int>()
        var temp = head
        while (temp?.`val` != null) {
            list.add(temp.`val`)
            temp = temp.next
        }
        var k = 1
        var res = 0
        for (i in list.size - 1 downTo 0) {
            res += list[i] * k
            k = k shl 1
        }
        return res
    }
}

fun main() {
    println(Solution().getDecimalValue(ListNode(1, ListNode(0, ListNode(1)))))
}