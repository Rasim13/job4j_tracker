package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item itemSecond = new Item(5, "Ivan");
        System.out.println(itemSecond);
    }
}
