package ru.job4j.lambda;

import java.util.Comparator;

public class LambdaUsage {
    public static void main(String[] args) {

        Comparator<String> cmpText = (left, right) -> {
            System.out.println("compare - " + left + " : " + right);
            return left.compareTo(right);
        };

        Comparator<String> cmpDescSize = (left, right) -> {
            System.out.println("compare - " + left + " : " + right);
            return Integer.compare(right.length(), left.length());
        };

        System.out.println(cmpText.compare("Ivan", "Artem"));
        System.out.println(cmpDescSize.compare("Ivan", "Artem"));
    }
}
