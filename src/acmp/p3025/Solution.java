package acmp.p3025;

import java.util.Arrays;
import java.util.Comparator;

//class Solution {
//    public int numberOfPairs(int[][] points) {
//        Arrays.sort(points, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if (o1[0] == o2[0]) {
//                    return o1[1] - o2[1];
//                }
//                return o2[0] - o1[0];
//            }
//        });
//
//        int n = points.length;
//        int m = points[0].length;
//
//        for (int i = 0; i < n; i++) {
//            int[] countsX = new int[i];
//            int[] countsY = new int[i];
//            for (int j = 0; j < i; j++) {
//                countsX[points[j][0]]++;
//                countsY[points[j][1]]++;
//            }
//            int indexX = 0, indexY = 0, result = 0;
//            while (indexX < i && countsX[indexX++] < 2) {
//                result++;
//            }
//            if (indexX == i && ) {
//
//            }
//        }
//
//    }
//}