package ru.job4j.tracker;

import java.util.List;

public class FindNameItemAction implements UserAction {
    private final Output out;

    public FindNameItemAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find Name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Введите имя: ");
//        Item item = new Item(name);
//        Item[] list = tracker.findByName(item.getName());
        List<Item> resultFind = tracker.findByName(name);
        if (resultFind.size() > 0) {
            for (int index = 0; index < resultFind.size(); index++) {
                out.println(resultFind.get(index));
            }
        } else {
                out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}
