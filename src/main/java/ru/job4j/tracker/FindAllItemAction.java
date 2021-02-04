package ru.job4j.tracker;

public class FindAllItemAction implements UserAction {
    private final Output out;

    public FindAllItemAction(Output out){
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find All ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] list = tracker.findAll();
        for (int index = 0; index < list.length; index++) {
            out.println("Список: " + list[index]);
        }
        return true;
    }
}
