package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askStr("Введите Id: "));
        Item item = new Item(id);
        tracker.delete(id);
        return true;
    }
}
