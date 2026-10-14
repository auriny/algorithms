package ru.auriny.lab2.student_sort;

import java.util.List;

public class StudentSort implements Sorting<Student> {
    @Override
    public void sort(List<Student> students) {
        if (students.size() <= 1) return;

        for (int i = 1; i < students.size(); i++) {
            var el = students.get(i);
            int j;

            for (j = i - 1; j >= 0; j--) {
                var left = students.get(j);
                if (el.compareTo(left) > 0) {
                    students.set(j + 1, left);
                } else break;
            }

            students.set(j + 1, el);
        }
//        students.sort(Student::compareTo);
    }
}
