package ru.auriny.lab5;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapImpl<V> implements HashMap<String, V> {
    private static final int TABLE_SIZE = 300007;
    private static final int A = 31;

    private final ArrayList<LinkedList<Entry<V>>> table;

    public HashMapImpl() {
        this.table = new ArrayList<>(TABLE_SIZE);
        for (int i = 0; i < TABLE_SIZE; i++) {
            table.add(new LinkedList<>());
        }
    }

    /**
     * Алгоритм хеширования строк.
     *
     * @param value ключ, по которому сохранится значение в хэш-таблицу
     * @return значение хэша
     */
    private long hashByString(String value) {
        long hash = 0;
        for (Character ch : value.toCharArray()) {
            hash = (hash * A + ch) % TABLE_SIZE;
        }
        return hash;
    }

    @Override
    public void put(String key, V value) {
        int ix = (int) hashByString(key);

        var box = table.get(ix);
        if (box == null)  {
            box = new LinkedList<>();
            box.add(new Entry<>(key, value));
            table.set(ix, box);
        } else {
            for (var entry : box) {
                if (entry.key.equals(key)) {
                    entry.value = value;
                    return; // выходим из метода
                }
            }
            // если цикл завершился и не вышел, значит ключа нет и надо создать новый
            box.add(new Entry<>(key, value));
        }
    }

    @Override
    public V getValue(String key) {
        int ix = (int) hashByString(key);

        var box = table.get(ix);
        if (box == null) return null; // ранний выход

        for (var entry : box) { // если нашелся элемент
            if (entry.key.equals(key)) { // просто возвращаем его
                return entry.value;
            }
        }

        return null;
    }

    @Override
    public V delete(String key) {
        int ix = (int) hashByString(key);

        var box = table.get(ix);
        if (box == null) return null;

        // так как мы знаем, что на этот раз используется связный список,
        // придётся удалять через итератор
        var iterator = box.iterator();
        while (iterator.hasNext()) { // за O(n) ищем нужный элемент
            var entry = iterator.next();
            if (entry.key.equals(key)) {
                iterator.remove(); // удаляет текущий элемент из связного списка за O(1)
                return entry.value; // возвращаем значение удаленного элемента
            }
        }

        return null; // ключ не найден
    }

    private static class Entry<V> {
        String key;
        V value;

        public Entry(String key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}