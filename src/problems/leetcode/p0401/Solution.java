package problems.leetcode.p0401;

import java.util.*;

class Solution {

    Map<Integer, Boolean> map = new HashMap<>();

    public List<String> readBinaryWatch(int turnedOn) {
        int[] hours = new int[]{1, 2, 4, 8};
        int[] minutes = new int[]{1, 2, 4, 8, 16, 32};

        List<String> res = new ArrayList<>();

        for (int i = Math.max(0, turnedOn - minutes.length); i <= Math.min(hours.length, turnedOn); i++) {
            dfs(res, hours, i, new boolean[hours.length], 0, minutes, turnedOn - i, new boolean[minutes.length], 0);
        }

        return res;
    }

    private void dfs(
            List<String> res,
            int[] hours, int hourCount, boolean[] withoutHours, int hour,
            int[] minutes, int minuteCount, boolean[] withoutMinutes, int minute
    ) {
        if (hourCount == 0 && minuteCount == 0) {
            if (valid(hour, minute) && !map.containsKey(hour * 100 + minute)) {
                res.add(toString(hour, minute));
                map.put(hour * 100 + minute, true);
            }
            return;
        }
        if (hourCount > 0) {
            for (int i = 0; i < hours.length; i++) {
                if (!withoutHours[i]) {
                    withoutHours[i] = true;
                    dfs(
                            res,
                            hours,
                            hourCount - 1,
                            withoutHours,
                            hour + hours[i],
                            minutes,
                            minuteCount,
                            withoutMinutes,
                            minute
                    );
                    withoutHours[i] = false;
                }
            }
        } else if (minuteCount > 0) {
            for (int i = 0; i < minutes.length; i++) {
                if (!withoutMinutes[i]) {
                    withoutMinutes[i] = true;
                    dfs(
                            res,
                            hours,
                            hourCount,
                            withoutHours,
                            hour,
                            minutes,
                            minuteCount - 1,
                            withoutMinutes,
                            minute + minutes[i]
                    );
                    withoutMinutes[i] = false;
                }
            }
        }
    }

    private boolean valid(int hour, int minute) {
        return hour >= 0 && hour < 12 && minute >= 0 && minute < 60;
    }

    private String toString(int hour, int minute) {
        StringBuilder sb = new StringBuilder();
        sb.append(hour).append(':');
        if (minute < 10)
            sb.append('0');
        sb.append(minute);
        return sb.toString();
    }

    static void main() {
        Solution solution = new Solution();
//        System.out.println(solution.readBinaryWatch(1));
        System.out.println(solution.readBinaryWatch(2));
    }
}