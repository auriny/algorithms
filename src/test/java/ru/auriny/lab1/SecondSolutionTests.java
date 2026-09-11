package ru.auriny.lab1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SecondSolutionTests {
    @Test
    void testSolution() {
        SecondSolution sol = new SecondSolution();

        Assertions.assertEquals(2, sol.removeElementInplace(new ArrayList<>(List.of(4, 5, 5, 4)), 4));
        Assertions.assertEquals(5, sol.removeElementInplace(new ArrayList<>(List.of(0,2,6,6,1,0,4,6)), 6));
    }
}
