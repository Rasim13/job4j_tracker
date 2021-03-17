package ru.job4j.tracker;

public class FindIdItemAction implements UserAction {
    private final Output out;

    public FindIdItemAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askStr("Введите Id: "));
        Item findId = tracker.findById(id);
        if (findId != null) {
            out.println(findId);
        } else {
            out.println("Заявка с таким id не найдена");
        }
        return true;
    }
}
