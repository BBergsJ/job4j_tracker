package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askStr("Select:"));
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                Item[] allElem = tracker.findAll();
                for (Item item:allElem) {
                    System.out.println(item);
                }
            } else if (select == 2) {
                String oldId = input.askStr("Enter old Id: ");
                Item newName = new Item(input.askStr("Enter new name: "));
                if (tracker.replace(oldId, newName)) {
                    System.out.println("Success!");
                } else {
                    System.out.println("Error!");
                }
            } else if (select == 3) {
                String deleteId = input.askStr("Enter Id: ");
                if (tracker.delete(deleteId)) {
                    System.out.println("Success!");
                } else {
                    System.out.println("Error!");
                }
            } else if (select == 4) {
                Item findItem = tracker.findById(input.askStr("Enter Id: "));
                if (findItem != null) {
                    System.out.println("Item is : " + findItem.getName());
                } else {
                    System.out.println("Id not found.");
                }
            } else if (select == 5) {
                String findName = input.askStr("Enter Name: ");
                Item[] names = tracker.findByName(findName);
                if (names.length > 0) {
                    for (Item item : names) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Empty array");
                }
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
