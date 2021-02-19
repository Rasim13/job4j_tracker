package ru.job4j.collection;

import java.util.List;
import java.util.ArrayList;

public class ConvertList {
    public static List<Integer> convert(List<int[]> list) {
        List<Integer> rsl = new ArrayList<>();
        for (int[] array: list) {
            for (int i: array) {
                rsl.add(i);
            }
        }
        return rsl;
    }
}
