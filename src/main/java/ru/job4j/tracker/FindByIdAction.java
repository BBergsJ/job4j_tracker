package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "===   Find item by Id  ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item findItem = tracker.findById(input.askStr("Enter Id: "));
        if (findItem != null) {
            System.out.println("Item is : " + findItem.getName());
        } else {
            System.out.println("Id not found.");
        }
        return true;
    }
}
