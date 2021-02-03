package ru.job4j.tracker;

public class FindAllItemAction implements UserAction {

    @Override
    public String name() {
        return "=== Find All ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] list = tracker.findAll();
        for (int index = 0; index < list.length; index++) {
            System.out.println("Список: " + list[index]);
        }
        return true;
    }
}
