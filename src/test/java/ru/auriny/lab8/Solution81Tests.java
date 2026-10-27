package ru.auriny.lab8;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution81Tests {
    private final InputStream standardIn = System.in;
    private final PrintStream standardOut = System.out;

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setIn(standardIn);
        System.setOut(standardOut);
    }

    @Test
    void testSumSequenceWithProblemExample() {
        String input = """
                10
                1 4 3 -6 2 6 -8 2 3 5
                0 9
                2 4
                3 7
                4 4
                """;

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Solution81 solution = new Solution81();
        solution.sum();

        String expectedOutput = """
                12
                -1
                -4
                2
                """;

        String actualOutput = outputStreamCaptor.toString().replace("\r\n", "\n").trim();
        expectedOutput = expectedOutput.replace("\r\n", "\n").trim();

        assertEquals(expectedOutput, actualOutput, "Суммы на отрезках вычислены неверно!");
    }
}
