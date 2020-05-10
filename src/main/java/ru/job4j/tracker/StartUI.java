package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.println("Select:");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                Item[] allElem = tracker.findAll();
                for (Item item:allElem) {
                    System.out.println(item);
                }
            } else if (select == 2) {
                System.out.println("Enter old Id: ");
                String oldId = scanner.nextLine();
                System.out.println("Enter new name: ");
                Item newName = new Item(scanner.nextLine());
                if (tracker.replace(oldId, newName)) {
                    System.out.println("Success!");
                } else {
                    System.out.println("Error!");
                }
            } else if (select == 3) {
                System.out.println("Enter Id: ");
                String deleteId = scanner.nextLine();
                if (tracker.delete(deleteId)) {
                    System.out.println("Success!");
                } else {
                    System.out.println("Error!");
                }
            } else if (select == 4) {
                System.out.println("Enter Id: ");
                Item findItem = tracker.findById(scanner.nextLine());
                if (findItem != null) {
                    System.out.println("Item is : " + findItem.getName());
                } else {
                    System.out.println("Id not found.");
                }
            } else if (select == 5) {
                System.out.println("Enter Name: ");
                String findName = scanner.nextLine();
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
