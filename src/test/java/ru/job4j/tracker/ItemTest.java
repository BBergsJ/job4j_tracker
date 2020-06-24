package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void compare() {
        List<Item> items = Arrays.asList(
                new Item("Bob"),
                new Item("Artur"),
                new Item("Dima"),
                new Item("Colya")
        );
        Collections.sort(items);
    }
}