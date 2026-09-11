package ru.auriny.lab1;

import java.util.List;

public class SecondSolution {
    public int removeElementInplace(List<Integer> arr, int val) {
        var ix = 0;

        for (var num : arr) {
            if (num != val) {
                arr.set(ix, num);
                ix++;
            }
        }

        return ix;
    }

    public int removeElement(int[] nums, int val) {
        var ix = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[ix] = nums[i];
                ix++;
            }
        }

        return ix;
    }
}
