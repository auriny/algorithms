package ru.auriny.lab1;

import java.util.HashSet;
import java.util.List;

public class ThirdSolution {
    public boolean containsDuplicate(List<Integer> nums) {
        // это о(н), а за о(н лог(н)) я хз как, сортировкой наверное
        return nums.size() != new HashSet<>(nums).size();
    }
}
