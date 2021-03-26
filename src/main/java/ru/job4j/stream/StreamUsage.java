package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(-2, 5, 8, -9, -7, 6));
        List<Integer> positiveNumbers = numbers.stream()
                .filter(list -> list > 0)
                .collect(Collectors.toList());
        positiveNumbers.forEach(System.out::print);
    }
}
