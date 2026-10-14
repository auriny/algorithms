package ru.auriny.lab2;

import org.junit.jupiter.api.Test;
import ru.auriny.lab2.student_sort.Student;
import ru.auriny.lab2.student_sort.StudentSort;

import java.util.ArrayList;
import java.util.List;

public class StudentSortTests {
    @Test
    void studentSort() {
        StudentSort sort = new StudentSort();
        List<Student> students = new ArrayList<>(List.of(
                new Student("Anton", 22),
                new Student("Vasya", 21),
                new Student("Vasya", 19),
                new Student("Antonio", 23)
        ));
        students.forEach(s -> System.out.println(s.getName()));

        sort.sort(students);
        students.forEach(s -> System.out.println(s.getName()));
    }
}
