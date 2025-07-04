package leetcode.p3307

import kotlin.math.ln
import kotlin.math.pow

fun main() {
    val solutionKotlin = SolutionKotlin()
    println(solutionKotlin.kthCharacter(3, intArrayOf(0, 0, 0)))
}

class SolutionKotlin {
    fun kthCharacter(k: Long, operations: IntArray): Char {
        val step = find(k, operations)
        return 'a' + step % 26
    }

    fun find(k: Long, operations: IntArray): Int {
        if (k == 1L) return 0
        var degree = (ln(k.toDouble()) / ln(2.0)).toInt()
        var value = 2.0.pow(degree).toLong()
        if (value == k) {
            value /= 2
            degree--
        }
        return find(k - value, operations) + operations[degree]
    }
}