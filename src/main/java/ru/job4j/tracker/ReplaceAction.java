package ru.job4j.tracker;

public class ReplaceAction implements UserAction {

    @Override
    public String name() {
        return "=== Replace Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askStr("Введите Id: "));
        String name = input.askStr("Enter name: ");
        Item newItem = new Item(name);
        tracker.replace(id, newItem);
        return true;
    }
}
