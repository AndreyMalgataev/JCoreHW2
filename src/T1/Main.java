package T1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        SortedSet<Integer> sortedSet = new TreeSet<>();

        for (int i : intList) {
            if (i > 0 && i % 2 == 0) {
                sortedSet.add(i);
            }
        }

        sortedSet.forEach(System.out::println);
    }
}
