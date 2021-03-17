package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortByIdItemTest {

    @Test
    public void compare() {
        List<Item> items = Arrays.asList(
                new Item(2, "Алексей"),
                new Item(1, "Петр"),
                new Item(4, "Илья")
        );
        Collections.sort(items);
        List<Item> expected = Arrays.asList(
                new Item(1, "Петр"),
                new Item(2, "Алексей"),
                new Item(4, "Илья")
        );
        Assert.assertEquals("Test fail", expected, items);
    }

    @Test
    public void compareTo() {
        List<Item> items = Arrays.asList(
                new Item(2, "Алексей"),
                new Item(1, "Петр"),
                new Item(4, "Илья")
        );
        Collections.sort(items, new SortByIdItem());
        List<Item> expected = Arrays.asList(
                new Item(4, "Илья"),
                new Item(2, "Алексей"),
                new Item(1, "Петр")
        );
        Assert.assertEquals("Test fail", expected, items);
    }
}