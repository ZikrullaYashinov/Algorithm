package acmp.p0294;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int allCount1 = sc.nextInt();
        int lostPercent1 = sc.nextInt();
        int unitPrice1 = sc.nextInt();

        int allCount2 = sc.nextInt();
        int lostPercent2 = sc.nextInt();
        int unitPrice2 = sc.nextInt();


        int l1 =  allCount1 * lostPercent1 / 100;
        int l2 =  allCount2 * lostPercent2 / 100;
        int loss = l1 * unitPrice1 + l2 * unitPrice2;
        if (allCount1 - l1 > allCount2 - l2)
            loss += (allCount1 - l1 - allCount2 + l2) * unitPrice1;
        else
            loss += (allCount2 - l2 - allCount1 + l1) * unitPrice2;

        System.out.println(loss);
    }
}
