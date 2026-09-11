package ru.auriny.lab1;

import java.util.ArrayDeque;
import java.util.Deque;

public class FirstSolution {
    public boolean isValid(String str) {
        Deque<Character> stack = new ArrayDeque<>();

        for (var c : str.toCharArray() ) {
            switch (c) {
                case '(' ->  stack.push(')');
                case '[' -> stack.push(']');
                case '{' -> stack.push('}');
                default -> {
                    if (stack.isEmpty() || stack.pop() != c) return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
