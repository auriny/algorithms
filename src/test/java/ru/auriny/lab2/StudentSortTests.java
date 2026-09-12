package ru.auriny.lab2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class StudentSortTests {
    @Test
    void studentSort() {
        StudentSort sort = new StudentSort();
        List<Student> students = new ArrayList<>(List.of(
                new Student("Vasya", 21),
                new Student("Vasya", 19),
                new Student("Anton", 22),
                new Student("Antonio", 23)
        ));

        sort.sort(students);
    }
}
