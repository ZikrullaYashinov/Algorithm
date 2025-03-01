package random;

import java.util.*;

public class ItemsRandom {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Sardor");
        list.add("Valixon");
        list.add("Zikrulla");
        list.add("Nodirbek");
        list.add("Ibrat");
        list.add("Mirshod");
        list.add("Ixtiyor");
        list.add("Quvondiq");

        Collections.shuffle(list);

        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for (String s : list) {
            counter++;
            sb.append(s);
            if (counter % 2 == 0) {
                System.out.println(sb);
                sb = new StringBuilder();
                counter = 0;
            } else {
                sb.append(" : ");
            }
        }
    }
}
