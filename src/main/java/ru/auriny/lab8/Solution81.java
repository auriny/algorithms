package ru.auriny.lab8;

import java.io.PrintWriter;
import java.util.Scanner;

public class Solution81 {
    public void sum() {
        // у нас нет лимитов по времени, поэтому используем просто сканер и просто принтер
        // по факту я вижу что K может быть вплоть до 10^7 (а это много вообще-то)
        // но раз по времени нас не ограничили я не планирую фастсканер писать
        try (Scanner sc = new Scanner(System.in); PrintWriter pw = new PrintWriter(System.out)) {
            if (!sc.hasNextInt()) return; // ранний выход в случае пустого ввода

            int N = sc.nextInt();
            int[] A = new int[N];

            for (int it = 0; it < N; it++) {
                A[it] = sc.nextInt();
            }

            // алгоритм префиксной суммы
            // нужен для выполнения подсчетов за о(1)
            int[] prefSum = new int[N + 1];
            for (int it = 0; it < N; it++) {
                // prefSum[k] хранит сумму первых k элементов
                prefSum[it + 1] = prefSum[it] + A[it];
            }

            while (sc.hasNext()) {
                int i = sc.nextInt();
                int j = sc.nextInt();

                // ищем сумму за О(1)
                // ну, то есть, у нас prefSum[j + 1] содержит сумму от начала до j
                // а prefSum[i] сумму до нашего отрезка
                // наша задача просто отсечь этот лишний префикс и мы узнаем нужную нам сумму
                int sum = prefSum[j + 1] - prefSum[i];

                pw.println(sum);
            }
        }
    }
}
