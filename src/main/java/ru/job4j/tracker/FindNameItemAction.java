package ru.job4j.tracker;

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
        Item item = new Item(name);
        Item[] list = tracker.findByName(item.getName());
        if (list.length > 0) {
            for (int index = 0; index < list.length; index++) {
                out.println(list[index]);
            }
        } else {
            out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}
