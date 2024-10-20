package examples;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@SuppressWarnings("ComparatorCombinators")
public class Example3b {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(List.of("acd", "kaoid", "opqpek", "ananwls", "ad", ""));

        // Sort the list by length of each string
        list.sort((o1, o2) -> o1.length() - o2.length());

        System.out.println(list);
    }
}
