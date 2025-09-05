package problems.leetcode.p3136

class Solution {
    fun isValid(word: String): Boolean {
        if (word.length < 3) return false

        for (ch in arrayOf('@', '#', '$'))
            if (ch in word) return false

        var hasVowel = false
        var hasConsonant = false
        val vowels = arrayOf('a', 'i', 'o', 'u', 'e', 'A', 'I', 'O', 'U', 'E')
        for (it in word)
            if (('a' <= it && it <= 'z') || ('A' <= it && it <= 'Z')) {
                if (it in vowels)
                    hasVowel = true
                else
                    hasConsonant = true
            }
        return hasConsonant && hasVowel
    }
}

fun main() {
    Solution().isValid("234Adas")
}