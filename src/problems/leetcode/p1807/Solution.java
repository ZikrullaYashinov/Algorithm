package problems.leetcode.p1807;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>(knowledge.size());

        for (List<String> k : knowledge)
            map.put(k.get(0), k.get(1));

        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        boolean start = false;
        for (char c : s.toCharArray()) {
            if (start && c == ')') {
                start = false;
                String value = map.get(temp.toString());
                if (value != null)
                    sb.append(value);
                else
                    sb.append('?');
                temp = new StringBuilder();
            } else if (!start && c == '(')
                start = true;
            else if (!start) sb.append(c);
            else temp.append(c);
        }
        return sb.toString();
    }

    static void main() {
        System.out.println(new Solution().evaluate("(fy)(kj)(ege)r", List.of(List.of("kj", "tzv"))));
    }
}