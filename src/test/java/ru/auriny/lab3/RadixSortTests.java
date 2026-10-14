package ru.auriny.lab3;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class RadixSortTests {
    @Test
    void testRadixSort() {
        var sort = new RadixSort();
        List<BigInteger> list = new ArrayList<>(List.of(
                new BigInteger("19446744073709551657"),
                new BigInteger("18446744073709551616"),
                new BigInteger("18446744073709551629"),
                new BigInteger("18446744073709551633")
        ));

        sort.sort(list);

        list.forEach(System.out::println);
    }
}
