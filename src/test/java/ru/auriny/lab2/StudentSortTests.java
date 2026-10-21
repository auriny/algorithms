package ru.auriny.lab2;

import org.junit.jupiter.api.Test;
import ru.auriny.lab2.student_sort.Student;
import ru.auriny.lab2.student_sort.StudentSort;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentSortTests {
    @Test
    void shouldSortStudentsCorrectly() {
        StudentSort sorter = new StudentSort();
        List<Student> students = new ArrayList<>(List.of(
                new Student("Vasya", 21),
                new Student("Vasya", 19),
                new Student("Anton", 22),
                new Student("Antonio", 23)
        ));

        sorter.sort(students);

        assertAll(
                () -> assertStudent(students.get(0), "Anton", 22),
                () -> assertStudent(students.get(1), "Antonio", 23),
                () -> assertStudent(students.get(2), "Vasya", 19),
                () -> assertStudent(students.get(3), "Vasya", 21)
        );
    }

    private void assertStudent(Student student, String expectedName, int expectedAge) {
        assertEquals(expectedName, student.getName(), "Не совпадает имя");
        assertEquals(expectedAge, student.getAge(), "Не совпадает возраст");
    }
}