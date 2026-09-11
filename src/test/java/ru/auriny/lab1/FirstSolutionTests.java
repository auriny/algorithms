package ru.auriny.lab1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class FirstSolutionTests {
    @Test
    void testFirstSolution() {
        FirstSolution fs = new FirstSolution();
        Assertions.assertTrue(fs.isValid("()"));
        Assertions.assertTrue(fs.isValid("()[]{}"));
        Assertions.assertFalse(fs.isValid("(]"));
        Assertions.assertTrue(fs.isValid("([])"));
        Assertions.assertFalse(fs.isValid("([)]"));


        Assertions.assertTrue(fs.isValid("([{{[()]}}])"));
    }
}
