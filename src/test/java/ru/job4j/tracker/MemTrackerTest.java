package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;

public class MemTrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        MemTracker memTracker = new MemTracker();
        Item item = new Item("test1");
        memTracker.add(item);
        Item result = memTracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

//    @Test
//    public void whenFindByNameThenFinded() {
//        Tracker tracker = new Tracker();
//        Item item = new Item("test1");
//        tracker.add(item);
//        Item result[] = tracker.findByName("test1");
//        assertThat(result[0].getName(), is(item.getName()));
//    }
//
//    @Test
//    public void whenFullArrayThenFindAll() {
//        Tracker tracker = new Tracker();
//        Item item1 = new Item("test1");
//        Item item2 = new Item("test2");
//        Item item3 = new Item("test3");
//        tracker.add(item1);
//        tracker.add(item2);
//        tracker.add(item3);
//        Item[] expected = new Item[] {item1, item2, item3};
//        Item[] out = tracker.findAll();
//        assertThat(out, is(expected));
//    }

    @Test
    public void whenReplace() {
        MemTracker memTracker = new MemTracker();
        Item bug = new Item("Bug");
        memTracker.add(bug);
        String id = bug.getId();
        Item bugWithDesc = new Item("Bug with description");
        memTracker.replace(id, bugWithDesc);
        assertThat(memTracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        MemTracker memTracker = new MemTracker();
        Item bug = new Item("Bug");
        Item item1 = new Item("test1");
        Item item2 = new Item("test2");
        Item item3 = new Item("test3");
        memTracker.add(bug);
        memTracker.add(item1);
        memTracker.add(item2);
        memTracker.add(item3);
        String id = bug.getId();
        memTracker.delete(id);
        assertThat(memTracker.findById(id), is(nullValue()));
    }
}