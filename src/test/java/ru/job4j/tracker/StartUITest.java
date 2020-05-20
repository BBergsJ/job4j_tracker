package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(new CreateAction(), is(expected.getName()));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {item.getId(), "replaced item"};
        Item replaced = tracker.findById(item.getId());
        assertThat(new EditAction(), is("replaced item"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);;
        String[] arrayDelItem = {item.getId()};
        Item deleted = tracker.findById(item.getId());
        Item expected = null;
        assertThat(new DeleteAction(), is(expected));
    }
}