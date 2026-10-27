package ru.auriny.lab5;

import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // возможно тут стоило написать фастсканер, но, как и в 8.1
        // у нас НЕТ ограничений по времени, а буферизированный ридер хуже читается
        try (Scanner sc = new Scanner(System.in); PrintWriter pw = new PrintWriter(System.out)) {
            var map = new HashMapImpl<String>(); // по условию у нас тут могут быть только строки

            while (sc.hasNext()) {
                String cmd = sc.next();
                String key = sc.next();
//                String value = sc.next();

                switch (cmd) {
                    case "put" -> {
                        String value = sc.next(); // пришлось перенести value сюда. некрасиво, но хоть работает
                        map.put(key, value);
                    }
                    case "get" -> pw.println(map.getValue(key));
                    case "delete" -> map.delete(key);
                    default -> throw new UnsupportedOperationException("Неизвестная команда: " + cmd);
                }
            }
        }
    }
}
