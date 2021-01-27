package ru.job4j.tracker;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Введите имя: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("Введите Id и имя: ");
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

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while(run) {
            this.showMenu();
            int select = Integer.valueOf(input.askStr("Выбор "));
                if (select == 0) {
                    StartUI.createItem(input, tracker);
                } else if (select == 1) {
                    StartUI.findAllItem(input, tracker);
                } else if (select == 2) {
                    StartUI.replaceItem(input, tracker);
                } else if (select == 3) {
                    StartUI.deleteItem(input, tracker);
                } else if (select == 4) {
                   StartUI.findIdItem(input, tracker);
                } else if (select == 5) {
                    StartUI.findNameItem(input, tracker);
                } else {
                    run = false;
                }
            }
        }

    private void showMenu() {
        System.out.println("Menu: ");
        System.out.println("0.Add new Item");
        System.out.println("1.Show all items");
        System.out.println("2.Edit item");
        System.out.println("3.Delete item");
        System.out.println("4.Find item by Id");
        System.out.println("5.Find items by name");
        System.out.println("6.Exit Program");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
