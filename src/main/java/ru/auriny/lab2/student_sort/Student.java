package ru.auriny.lab2.student_sort;

import java.util.Comparator;

public class Student {
    private final String name;
    private final int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int compareTo(Student o) {
        return Comparator.comparing(Student::getName)
                .thenComparing(Student::getAge)
                .compare(this, o);
    }
}