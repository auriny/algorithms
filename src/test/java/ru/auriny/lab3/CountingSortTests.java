package ru.auriny.lab3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CountingSortTests {
    @Test
    void testCountingSort() {
        CountingSort cs = new CountingSort();

        var list = new ArrayList<>(List.of(
                124, 68, 57, 0, 93, 60, 24, 71, 125, 70, 87, 83, 105, 34, 30, 15
        ));
        var expected = new ArrayList<>(List.of(
                0, 15, 24, 30, 34, 57, 60, 68, 70, 71, 83, 87, 93, 105, 124, 125
        ));

        cs.sort(list);

        for (int i = 0; i < list.size(); i++) {
//            Assertions.assertEquals(expected.get(i), list.get(i));
            IO.print(list.get(i) + " " + expected.get(i) + "\n");
        }
    }
}
