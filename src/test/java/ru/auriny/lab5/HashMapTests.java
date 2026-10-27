package ru.auriny.lab5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HashMapTests {
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
    void testHashMapWithProblemExample() {
        String input = """
                put hello world
                put name ilya
                get hello
                get ilya
                delete hello
                get hello
                get name
                put name vasya
                get name
                """;

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Main.main(new String[0]);

        String expectedOutput = """
                world
                null
                null
                ilya
                vasya
                """;

        String actualOutput = outputStreamCaptor.toString().replace("\r\n", "\n").trim();
        expectedOutput = expectedOutput.replace("\r\n", "\n").trim();

        assertEquals(expectedOutput, actualOutput, "Результат обработки команд не совпадает с ожидаемым!");
    }
}
