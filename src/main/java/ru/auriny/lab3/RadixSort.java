package ru.auriny.lab3;

import ru.auriny.lab2.Sorting;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class RadixSort implements Sorting<BigInteger> {
    @Override
    public void sort(List<BigInteger> nums) {
        if (nums.isEmpty()) return; // базовый случай - пустой массив на входе

        // мы будем работать с 10 "корзинами" - списком фиксированной длины,
        // в который мы "складываем" элементы изначального массива
        // такой подход позволяет нам вообще не сравнивать числа
        // и сортировать числа по разрядам
        List<List<BigInteger>> buckets = new ArrayList<>(10);

        // наполняем список этими корзинами. логичнее было бы использовать
        // List#of, но эффективнее и проще, как оказалось,
        // просто сделать цикл на 10 итераций
        for (var i = 0; i < 10; i++) buckets.add(new ArrayList<>());

        // я надеюсь, использовать стримы можно.
        // под капотом .max сортировок не использует,
        // так что вроде нормально должно быть все
        var max = nums.stream().max(BigInteger::compareTo).get();
        var val = BigInteger.ONE;

        // сортируем справа налево
        while (max.compareTo(val) >= 0) {
            // раскидываем по корзинам
            for (var num : nums) {
                // кстати, фан факт: BigInteger - иммутабельный, поэтому каждый вызов
                // divide, remainder будет создавать нам новые объекты в памяти при КАЖДОЙ итерации!
                // а это вызывает нагрузку на GC и увеличивает необходимое количество памяти
                // но это можно исправить, переписав это же через String или char[].
                // как по мне - бред таким заниматься.
                var digit = num.divide(val).remainder(BigInteger.TEN).intValue();
                buckets.get(digit).add(num);
            }

            // собираем обратно
            // как и было с сортировкой подсчетами, связный список
            // этот код раздует до O(n^2). но мы адекватные люди и знаем,
            // что тесты проходят на человеческих списках,
            // где запись элемента асимптотически является O(n)
            var count = 0;
            for (var bucket : buckets) {
                for (var num : bucket)
                    nums.set(count++, num);
                bucket.clear();
            }

            // переходим к следующему разряду
            val = val.multiply(BigInteger.TEN);
        }
    }
}