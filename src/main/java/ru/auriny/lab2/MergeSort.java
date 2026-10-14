package ru.auriny.lab2;

import java.util.ArrayList;
import java.util.List;

public class MergeSort implements Sorting<Integer> {
    private void slice(List<Integer> nums, int start, int end) {
        if (start >= end) return; // базовый случай
        int mid = start + (end - start) / 2;

        // в мердж сорте используется принцип "разделяй и властвуй"
        // мы делим наш массив на составные части до тех пор,
        // пока деление не перестанет быть возможным
        // то бишь, пока каждый подмассив не будет состоять из 1 эл.
        // иначе, что мы будем делить?
        slice(nums, start, mid); // левая половина
        slice(nums, mid + 1, end); // правая половина

        //а затем мы сливаем массивы в уже отсортированном порядке
        merge(nums, start, mid, end);
    }

    private void merge(List<Integer> nums, int start, int middle, int end) {
        // паттерн two pointers дабы оптимизировать O(n^2) до O(n)
        var leftPtr = start;
        var rightPtr = middle + 1;

        // временный список с упорядоченными эл-ами
        List<Integer> temp = new ArrayList<>();

        while (leftPtr <= middle && rightPtr <= end) {
            if (nums.get(leftPtr) <= nums.get(rightPtr)) {
                temp.add(nums.get(leftPtr++));
            } else temp.add(nums.get(rightPtr++));
        }

        // добавляем элементы списка в нужном порядке в темп лист
        while (leftPtr <= middle) temp.add(nums.get(leftPtr++));
        while (rightPtr <= end) temp.add(nums.get(rightPtr++));

        // восстанавливаем последовательность обратно
        for (int i = 0; i < temp.size(); i++) {
            nums.set(start + i, temp.get(i));
        }
    }

    @Override
    public void sort(List<Integer> nums) {
        if (nums.isEmpty()) return; // был подан пустой список - ранний выход
        slice(nums, 0, nums.size() - 1);
    }
}