package examples;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@SuppressWarnings("Convert2Lambda")
public class Example3a {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(List.of("acd", "kaoid", "opqpek", "ananwls", "ad", ""));

        // Sort the list by length of each string
        list.sort(new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        System.out.println(list);
    }
}
