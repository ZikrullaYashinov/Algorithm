package problems.leetcode.p2075;

class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        byte[] bytes = encodedText.getBytes();
        int cols = bytes.length / rows;

        byte[][] arr = new byte[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = bytes[i * cols + j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if (i + j < cols)
                    sb.append((char) arr[j][i + j]);
            }
        }

        return sb.toString().stripTrailing();
    }

    static void main() {
        System.out.println(new Solution().decodeCiphertext(" b  ac", 2));
        System.out.println(new Solution().decodeCiphertext("ch   ie   pr", 3));
    }
}