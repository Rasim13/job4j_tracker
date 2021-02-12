package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.nullValue;

public class StartUITestReplaceItem {

    @Test
    public void WhenReplaceItem() {
        Tracker tracker = Tracker.getInstance();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId()),
                "replaced item"};
        //StartUI.replaceItem(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
    }

    @Test
    public void WhenDeleteItem() {
        Tracker tracker = Tracker.getInstance();
        Item item = new Item("new Item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId())};
        //StartUI.deleteItem(new StubInput(answers), tracker);
        Item deleted = tracker.findById(item.getId());
        assertThat(deleted, is(nullValue()));
    }
}