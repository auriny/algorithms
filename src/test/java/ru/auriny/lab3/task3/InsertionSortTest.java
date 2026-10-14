package ru.auriny.lab3.task3;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InsertionSortTest {
    @Test
    void testIntegerSort() {
        var sorter = new InsertionSort<Integer>();
        var list = new ArrayList<>(List.of(5, 2, 8, 1, 9));

        sorter.sort(list);

        assertEquals(List.of(1, 2, 5, 8, 9), list);
    }

    @Test
    void testStringSort() {
        var sorter = new InsertionSort<String>();
        var list = new ArrayList<>(List.of("Banana", "Apple", "Cherry"));

        sorter.sort(list);

        assertEquals(List.of("Apple", "Banana", "Cherry"), list);
    }

    @Test
    void testLocalDateTimeSort() {
        var sorter = new InsertionSort<LocalDateTime>();
        var now = LocalDateTime.now();
        var tomorrow = now.plusDays(1);
        var yesterday = now.minusDays(1);

        var list = new ArrayList<>(List.of(tomorrow, now, yesterday));

        sorter.sort(list);

        assertEquals(List.of(yesterday, now, tomorrow), list);
    }

    @Test
    void testUuidSort() {
        var sorter = new InsertionSort<UUID>();
        var u1 = UUID.fromString("00000000-0000-0000-0000-000000000001");
        var u2 = UUID.fromString("00000000-0000-0000-0000-000000000002");
        var u3 = UUID.fromString("00000000-0000-0000-0000-000000000003");

        var list = new ArrayList<>(List.of(u3, u1, u2));

        sorter.sort(list);

        assertEquals(List.of(u1, u2, u3), list);
    }

    @Test
    void testStudentSort() {
        var sorter = new InsertionSort<Student>();
        var s1 = new Student("Alice", 20);
        var s2 = new Student("Bob", 19);
        var s3 = new Student("Charlie", 21);

        var list = new ArrayList<>(List.of(s3, s1, s2));

        sorter.sort(list);

        assertEquals(List.of(s2, s1, s3), list);
    }

    record Student(String name, int age) implements Comparable<Student> {
        @Override
        public int compareTo(Student other) {
            return Integer.compare(this.age, other.age);
        }
    }
}