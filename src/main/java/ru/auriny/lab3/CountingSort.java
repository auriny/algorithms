package ru.auriny.lab3;

import ru.auriny.lab2.Sorting;

import java.util.*;

public class CountingSort implements Sorting<Integer> {
    @Override
    public void sort(List<Integer> nums) {
        // прикольный массив: в него мы записываем
        // КОЛИЧЕСТВО встреченного элемента,
        // а так как у нас все элементы идут поочередно,
        // мы используем в качестве индекса само число
        var temp = new int[128]; // бтв тут изначально была хешмапа
        var count = 0; // считаем количество элемента
        nums.forEach(id -> temp[id]++);

        // вообще, при связном списке тут может возникнуть случайно O(n^2)
        // поэтому тут можно использовать итератор,
        // но я не буду
        for (var i = 0; i < temp.length; i++) {
            for (var j = 0; j < temp[i]; j++) {
                nums.set(count++, i);
            }
        }
    }
}
