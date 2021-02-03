package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askStr("Введите Id: "));
        if (tracker.delete(id)) {
            System.out.println("Id удалена успешна");
        } else {
            System.out.println("Не получилось удалить");
        }
        return true;
    }
}
