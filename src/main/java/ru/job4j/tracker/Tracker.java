package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Tracker {
    private static Tracker instance = null;
    //private final Item[] items = new Item[100];
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    private Tracker() {

    }

    public static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }

    public Item add(Item item) {
        item.setId(ids++);
        //items[size++] = item;
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

//    public Item[] findAll() {
//        return Arrays.copyOf(items, size);
//    }

    public List<Item> findAll() {
        return List.copyOf(items);
    }

//    public Item[] findByName(String key) {
//        int count = 0;
//        Item[] namesSimilar = new Item[items.length];
//        for (int index = 0; index < size; index++) {
//            Item name = items[index];
//            if (name.getName().equals(key)) {
//                namesSimilar[count] = name;
//                count++;
//            }
//        }
//        return Arrays.copyOf(namesSimilar, count);
//    }

    public List<Item> findByName(String key){
        List<Item> rsl = new ArrayList<>();
        for (Item it : items) {
            if (it.getName().contains(key)) {
                rsl.add(it);
            }
        }
        return List.copyOf(rsl);
    }

    public boolean replace(int id, Item item) {
        boolean rsl = false;
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            //items[index] = item;
            items.set(index, item);
            rsl = true;
        }
        return rsl;
    }

    private int indexOf(int id) {
        int rsl = -1;
//        for (int index = 0; index < size; index++) {
//            if (items[index].getId() == id) {
        int index = 0;
        for (Item it : items) {
            if (it.getId() == id) {
                rsl = index;
                break;
            }
            index++;
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (index != -1) {
//            System.arraycopy(items, index + 1, items, index, size - index);
//            items[size - 1] = null;
//            size--;
            items.remove(index);
        }
        return rsl;
    }

}