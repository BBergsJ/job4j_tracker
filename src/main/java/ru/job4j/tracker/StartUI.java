package ru.job4j.tracker;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showAllItems(Tracker tracker) {
        Item[] allElem = tracker.findAll();
        for (Item item:allElem) {
            System.out.println(item);
        }
    }

    public static void editItem(Input input, Tracker tracker) {
        String oldId = input.askStr("Enter old Id: ");
        Item newName = new Item(input.askStr("Enter new name: "));
        if (tracker.replace(oldId, newName)) {
            System.out.println("Success!");
        } else {
            System.out.println("Error!");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        String deleteId = input.askStr("Enter Id: ");
        if (tracker.delete(deleteId)) {
            System.out.println("Success!");
        } else {
            System.out.println("Error!");
        }
    }

    public static void findId(Input input, Tracker tracker) {
        Item findItem = tracker.findById(input.askStr("Enter Id: "));
        if (findItem != null) {
            System.out.println("Item is : " + findItem.getName());
        } else {
            System.out.println("Id not found.");
        }
    }

    public static void findName(Input input, Tracker tracker) {
        String findName = input.askStr("Enter Name: ");
        Item[] names = tracker.findByName(findName);
        if (names.length > 0) {
            for (Item item : names) {
                System.out.println(item);
            }
        } else {
            System.out.println("Empty array");
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askStr("Select:"));
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.showAllItems(tracker);
            } else if (select == 2) {
                StartUI.editItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findId(input, tracker);
            } else if (select == 5) {
                StartUI.findName(input, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        // добавить остальные пункты меню.
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
