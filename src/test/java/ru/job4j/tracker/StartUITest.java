package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = Tracker.getInstance();
//        UserAction[] actions = {
//                new CreateAction(out),
//                new Exit()
//        };
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new Exit());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = Tracker.getInstance();
        Item item = tracker.add(new Item("Replaced item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        int id = item.getId();
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(id), replacedName, "1"}
        );
//        UserAction[] actions = {
//                new ReplaceAction(out),
//                new Exit()
//        };
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ReplaceAction(out));
        actions.add(new Exit());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = Tracker.getInstance();
        Item item = tracker.add(new Item("Deleted item"));
        int id = item.getId();
        Input in = new StubInput(
                new String[] {"0", String.valueOf(id), "1"}
        );
//        UserAction[] actions = {
//                new DeleteAction(out),
//                new Exit()
//        };
        List<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteAction(out));
        actions.add(new Exit());
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenFindAllItemAction() {
        Output out = new StubOutput();
        Tracker tracker = Tracker.getInstance();
        Input in = new StubInput(
                new String[] {"1"}
        );
//        UserAction[] actions = {
//                new FindAllItemAction(out),
//                new Exit()
//        };
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindAllItemAction(out));
        actions.add(new Exit());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu.\r\n0. === Find All ====\r\n1."
                + " Exit\r\n"));
    }

    @Test
    public void whenFindIdItemAction() {
        Output out = new StubOutput();
        Tracker tracker = Tracker.getInstance();
        Input in = new StubInput(
                new String[] {"1"}
        );
//        UserAction[] actions = {
//                new FindIdItemAction(out),
//                new Exit()
//        };
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindIdItemAction(out));
        actions.add(new Exit());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu.\r\n0. === Find Id ====\r\n1."
                + " Exit\r\n"));
    }

    @Test
    public void whenFindNameItemAction() {
        Output out = new StubOutput();
        Tracker tracker = Tracker.getInstance();
        Input in = new StubInput(
                new String[] {"1"}
        );
//        UserAction[] actions = {
//                new FindNameItemAction(out),
//                new Exit()
//        };
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindNameItemAction(out));
        actions.add(new Exit());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu.\r\n0. === Find Name ====\r\n1."
                + " Exit\r\n"));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "0"}
        );
        Tracker tracker = Tracker.getInstance();
//        UserAction[] actions = {
//                new Exit()
//        };
        List<UserAction> actions = new ArrayList<>();
        actions.add(new Exit());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. Exit%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu.%n"
                                + "0. Exit%n"
                )
        ));
    }
}