package ru.auriny.lab2;

import java.util.ArrayList;
import java.util.List;

public class MergeSort implements Sorting<Integer> {
    private void slice(List<Integer> nums, int start, int end) {
        int mid = start + (end - start) / 2;

        slice(nums, start, mid); // левая половина
        slice(nums, mid + 1, end); // правая половина

        merge(nums, start, mid, end);
    }

    private void merge(List<Integer> nums, int start, int middle, int end) {
        var leftPtr = start;
        var rightPtr = middle + 1;

        List<Integer> temp = new ArrayList<>();

        while (leftPtr <= middle && rightPtr <= end) {
            if (nums.get(leftPtr) <= nums.get(rightPtr)) {
                temp.add(nums.get(leftPtr++));
            } else temp.add(nums.get(rightPtr++));
        }

        while (leftPtr <= middle) temp.add(nums.get(leftPtr++));
        while (rightPtr <= end) temp.add(nums.get(rightPtr++));

        for (int i = 0; i < temp.size(); i++) {
            nums.set(i, temp.get(i));
        }
    }

    @Override
    public void sort(List<Integer> nums) {
        slice(nums, 0, nums.size() - 1);
    }
}