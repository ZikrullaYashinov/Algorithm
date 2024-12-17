package leetcode;

public class P2182 {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] arr = new int[26];
        byte[] bytes = s.getBytes();

        for (byte i : bytes)
            arr[i - 'a']++;

        StringBuilder sb = new StringBuilder();
        int i = 25;
        while (i >= 0) {
            if (arr[i] > repeatLimit) {
                sb.repeat('a' + i, repeatLimit);
                arr[i] -= repeatLimit;
                boolean has = false;
                for (int j = i - 1; !has && j >= 0; j--) {
                    if (arr[j] > 0) {
                        sb.repeat('a' + j, 1);
                        arr[j]--;
                        has = true;
                    }
                }
                if (!has) break;
            } else {
                sb.repeat('a' + i, arr[i]);
                i--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}


