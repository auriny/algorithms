package ru.auriny.lab1;

import java.util.HashSet;
import java.util.List;

public class ThirdSolution {
    public boolean containsDuplicate(List<Integer> nums) {
        // это о(н), а за о(н лог(н)) я хз как, сортировкой наверное
        // > !!!
        // оказывается это в среднем o(N), а в худшем случае это O(N*log(n)),
        // так что ФОРМАЛЬНО я уложился в задачу
        // можно для повышения эффективности добавить early exit,
        // но толку я вижу маловато, это раздует решение в 6 раз
        return nums.size() != new HashSet<>(nums).size();
    }
}
