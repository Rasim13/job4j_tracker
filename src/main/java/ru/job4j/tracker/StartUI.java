package ru.job4j.tracker;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Введите имя: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void replaceItem(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askStr("Введите Id: "));
        String name = input.askStr("Введите имя: ");
        Item newItem = new Item(name);
        if (tracker.replace(id, newItem)) {
            System.out.println("Замена прошла успешна");
        } else {
            System.out.println("Не получилось заменить");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askStr("Введите Id: "));
        if (tracker.delete(id)) {
            System.out.println("Id удалена успешна");
        } else {
            System.out.println("Не получилось удалить");
        }
    }

    public static void findAllItem(Input input, Tracker tracker) {
        Item[] list = tracker.findAll();
        for (int index = 0; index < list.length; index++) {
            System.out.println("Список: " + list[index]);
        }
    }

    public static void findIdItem(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askStr("Введите Id: "));
        Item findId = tracker.findById(id);
        if (findId != null) {
            System.out.println(findId);
        } else {
            System.out.println("Заявка с таким id не найдена");
        }
    }

    public static void findNameItem(Input input, Tracker tracker) {
        String name = input.askStr("Введите имя: ");
        Item item = new Item(name);
        Item[] list = tracker.findByName(item.getName());
        if (list.length > 0) {
            for (int index = 0; index < list.length; index++) {
                System.out.println(list[index]);
            }
        } else {
            System.out.println("Заявки с таким именем не найдены");
        }
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while(run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
            }
        }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for(int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateAction()};
        new StartUI().init(input, tracker, actions);
    }
}
