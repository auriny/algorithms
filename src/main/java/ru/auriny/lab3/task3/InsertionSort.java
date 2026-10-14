package ru.auriny.lab3.task3;

import java.util.List;

public class InsertionSort<T extends Comparable<? super T>> implements Sorting<T> {
    // Тесты: ru.auriny.lab3.task3.InsertionSortTest
    // здесь используем обычный инсершн сорт, он самый простой,
    // а самое главное - уже готовый!
    @Override
    public void sort(List<T> nums) {
        if (nums.size() <= 1) return;

        for (int i = 1; i < nums.size(); i++) {
            var el = nums.get(i);
            int j;

            for (j = i - 1; j >= 0; j--) {
                var left = nums.get(j);

                // используем здесь компаратор вместо
                // числового сравнения. я делал ровно то же самое
                // в StudentSort.java
                if (el.compareTo(left) < 0) {
                    nums.set(j + 1, left);
                } else break;
            }

            nums.set(j + 1, el);
        }
    }
}