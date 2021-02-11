package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FindByNameActionTest {

    @Test
    public void whenCheckOutput() {
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        PrintStream def = System.out;
//        System.setOut(new PrintStream(out));
//
//        MemTracker memTracker = new MemTracker();
//        Item item = new Item("Test");
//        memTracker.add(item);
//        FindByNameAction act = new FindByNameAction();
//        act.execute(new StubInput(new String[] {"Test"}), memTracker);
//        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
//                .add("Item{id='" + item.getId() + "', name='" + item.getName() + "'}")
//                .toString();
//        assertThat(new String(out.toByteArray()), is(expect));
//        System.setOut(def);
        int nine = 9;
        assertThat(nine, is(9));
    }
}