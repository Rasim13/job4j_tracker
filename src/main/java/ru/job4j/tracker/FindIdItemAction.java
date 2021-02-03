package ru.job4j.tracker;

public class FindIdItemAction implements UserAction {
    @Override
    public String name() {
        return "=== Find Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askStr("Введите Id: "));
        Item findId = tracker.findById(id);
        if (findId != null) {
            System.out.println(findId);
        } else {
            System.out.println("Заявка с таким id не найдена");
        }
        return true;
    }
}
