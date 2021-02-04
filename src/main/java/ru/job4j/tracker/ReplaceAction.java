package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out){
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Replace Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askStr("Введите Id: "));
        String name = input.askStr("Введите имя: ");
        Item newItem = new Item(name);
        if (tracker.replace(id, newItem)) {
            out.println("Замена прошла успешна");
        } else {
            out.println("Не получилось заменить");
        }
        return true;
    }
}
