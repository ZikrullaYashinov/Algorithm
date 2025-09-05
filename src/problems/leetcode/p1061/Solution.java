package problems.leetcode.p1061;

class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        char[] chars = new char[26];

        for (byte i = 0; i < 26; i++) {
            chars[i] = (char) ('a' + i);
        }

        int n = s1.length();

        char ch1, ch2, _ch1, _ch2, min;

        for (int i = 0; i < n; i++) {
            ch1 = s1.charAt(i);
            ch2 = s2.charAt(i);
            _ch1 = chars[ch1 - 'a'];
            _ch2 = chars[ch2 - 'a'];

            min = (char) Math.min(Math.min(_ch1, _ch2), Math.min(ch1, ch2));

            if (ch1 > min)
                replace(chars, ch1, min);
            if (ch2 > min)
                replace(chars, ch2, min);
            if (_ch1 > min)
                replace(chars, _ch1, min);
            if (_ch2 > min)
                replace(chars, _ch2, min);
        }

        StringBuilder sb = new StringBuilder();
        n = baseStr.length();
        for (int i = 0; i < n; i++) {
            sb.append(chars[baseStr.charAt(i) - 'a']);
        }

        return sb.toString();
    }

    private void replace(char[] chars, char ch1, char ch2) {
        for (int i = 0; i < 26; i++)
            if (chars[i] == ch1)
                chars[i] = ch2;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.smallestEquivalentString("hello", "world", "hold"));
        System.out.println(solution.smallestEquivalentString("parker", "morris", "parser"));
    }
}