package ru.auriny.lab2;

import java.util.List;

public class InsertionSort implements Sorting<Integer> {
    @Override // ура изобретаем велосипед!
    public void sort(List<Integer> nums) {
//        nums.sort(null);
//        IO.print(nums);

        if (nums == null || nums.size() <= 1) return;

        for (int i = 1; i < nums.size(); i++) {
            var el = nums.get(i);
            int j;

            for (j = i - 1; j >= 0; j--) {
                var right = nums.get(j);
                if (el < right) {
                    nums.set(j + 1, right);
                } else break;
            }

            nums.set(j + 1, el);
        }

        IO.print(nums);
    }
}
