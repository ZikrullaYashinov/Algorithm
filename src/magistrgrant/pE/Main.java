package magistrgrant.pE;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[6];
        for (int i = 0; i < 6; i++) {
            arr[i] = sc.nextInt();
        }

        int h1 = sc.nextInt();
        int h2 = sc.nextInt();

        int[] res = new int[6];

        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                for (int k = j + 1; k < 6; k++) {
                    if (arr[i] + arr[j] + arr[k] == h1) {
                        int index = 0;
                        res[index++] = arr[i];
                        res[index++] = arr[j];
                        res[index++] = arr[k];

                        int _h2 = 0;
                        int[] temp = new int[3];
                        int tempIndex = 0;
                        for (int l = 0; l < 6; l++) {
                            if (l != i && l != j && l != k) {
                                res[index++] = arr[l];
                                _h2 += arr[l];
                                temp[tempIndex++] = l;
                            }
                        }

                        if (_h2 == h2
                                && res[0] != res[1]
                                && res[0] != res[2]
                                && res[2] != res[1]
                                && res[3] != res[4]
                                && res[3] != res[5]
                                && res[5] != res[4]
                        ) {
                            result(res);
                            return;
                        }
                    }
                }
            }
        }


    }

    private static void result(int[] res) {
        Arrays.sort(res, 0, 3);
        Arrays.sort(res, 3, 6);

        int[] ans = new int[6];

        for (int i = 0; i < 3; i++) {
            ans[i] = res[2 - i];
            ans[i + 3] = res[5 - i];
        }

        for (int i = 0; i < 6; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}