package ru.auriny.lab2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class InsertionSortTests {
    @Test
    void insertionSort() {
        InsertionSort insertionSort = new InsertionSort();
        List<Integer> list = new ArrayList<>(List.of(1, 2, 5, 1, 1, 2, 6, 8, 9, 3));
        insertionSort.sort(list);

        Assertions.assertEquals(new ArrayList<>(List.of(1, 1, 1, 2, 2, 3, 5, 6, 8, 9)), list);
    }
}
