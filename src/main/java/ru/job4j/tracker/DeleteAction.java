package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter id: ");
        Item item = new Item();
        int id = item.getId();
        tracker.delete(id);
        return true;
    }
}
