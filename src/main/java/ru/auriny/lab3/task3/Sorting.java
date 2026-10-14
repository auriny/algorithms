package ru.auriny.lab3.task3;

import java.util.List;

public interface Sorting<T extends Comparable<? super T>> {
    void sort(List<T> nums);
}
