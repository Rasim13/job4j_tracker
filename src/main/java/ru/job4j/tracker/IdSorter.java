package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class IdSorter {
    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
                new Item(2, "Алексей"),
                new Item(1, "Петр"),
                new Item(4, "Илья")
        );

        System.out.println(items);
        Collections.sort(items);
        System.out.println(items);
        Collections.sort(items, new SortByIdItem());
        System.out.println(items);
    }
}
