package problems.acmp.p0639;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            sc.nextLine();
            for (int j = 0; j < m; j++) {
                list.add(sc.nextLine());
            }
        }
        list.sort(Comparator.reverseOrder());
        System.out.println(list.size());
        for (String s : list) {
            System.out.println(s);
        }
    }
}
