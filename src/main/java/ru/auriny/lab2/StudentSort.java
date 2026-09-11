package ru.auriny.lab2;

import java.util.List;

public class StudentSort implements Sorting<Student> {
    @Override
    public void sort(List<Student> students) {
        students.sort(Student::compareTo);
        students.forEach(this::printStudent);
    }

    void printStudent(Student student) {
        IO.print(String.format("%s %s\n", student.getName(), student.getAge()));
    }
}
