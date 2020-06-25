package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class ItemTest {

    @Test
    public void whenIncreasing() {
        List<Item> items = Arrays.asList(
                new Item("Bob"),
                new Item("Artur"),
                new Item("Dima"),
                new Item("Colya")
        );
        Collections.sort(items, new ItemSortIncrease());
        List<Item> sorted = Arrays.asList(
                new Item("Artur"),
                new Item("Bob"),
                new Item("Colya"),
                new Item("Dima")
        );
        assertThat(sorted, is(items));
    }

    @Test
    public void whenDecreasing() {
        List<Item> items = Arrays.asList(
                new Item("Bob"),
                new Item("Artur"),
                new Item("Dima"),
                new Item("Colya")
        );
        Collections.sort(items, new ItemSortDecrease());
        List<Item> sorted = Arrays.asList(
                new Item("Dima"),
                new Item("Colya"),
                new Item("Bob"),
                new Item("Artur")
        );
        assertThat(sorted, is(items));
    }
}