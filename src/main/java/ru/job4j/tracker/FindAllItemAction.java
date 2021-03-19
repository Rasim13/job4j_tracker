package ru.job4j.tracker;

import java.util.List;

public class FindAllItemAction implements UserAction {
    private final Output out;

    public FindAllItemAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find All ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        //Item[] list = tracker.findAll();
        List<Item> resultFindAll = tracker.findAll();
        for (int index = 0; index < resultFindAll.size(); index++) {
            out.println("Список: " + resultFindAll.get(index));
        }
        return true;
    }
}
