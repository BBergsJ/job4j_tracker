package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

public class Tracker {
    private final Item[] items = new Item[100];
    private int position = 0;

    public Item add(Item item) {
        item.setId(generateId());
        items[position++] = item;
        return item;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, position);
    }

    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

    public Item[] findByName(String key) {
        Item[] itemsFinded = new Item[position];
        int size = 0;
        for (int i = 0; i < position; i++) {
            if (items[i].getName().equals(key)) {
                itemsFinded[size] = items[i];
                size++;
            }
        }
        itemsFinded = Arrays.copyOf(itemsFinded, size);
        return itemsFinded;
    }

    public Item findById(String id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    private int indexOf(String id) {
        int rsl = -1;
        for (int index = 0; index < position; index++) {
            if (items[index].getId().equals(id)) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(String id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            items[index].setName(item.getName());
        }
        return rsl;
    }

    public boolean delete(String id) {
        int index = indexOf(id);
        int start = index + 1;
        int size = position - index;
        boolean rsl = index != -1;
        if (rsl) {
            items[index] = null;
            System.arraycopy(items, start, items, index, size);
            position--;
        }

        return rsl;
    }
}