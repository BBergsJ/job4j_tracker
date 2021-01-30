package ru.job4j.tracker;

import java.util.List;

public class ShowAllAction implements UserAction {
    @Override
    public String name() {
        return "===   Show all items  ====";
    }

    @Override
    public boolean execute(Input input, MemTracker memTracker) {
        List<Item> allElem = memTracker.findAll();
        for (Item item:allElem) {
            System.out.println(item);
        }
        return true;
    }
}
