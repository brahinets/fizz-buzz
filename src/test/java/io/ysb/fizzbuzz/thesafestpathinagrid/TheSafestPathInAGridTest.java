package io.ysb.fizzbuzz.thesafestpathinagrid;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TheSafestPathInAGridTest {

    @Test
    void allUnsafe() {
        TheSafestPathInAGrid solution = new TheSafestPathInAGrid();

        assertEquals(0, solution.maximumSafenessFactor(List.of(
                List.of(1, 0, 0),
                List.of(0, 0, 0),
                List.of(0, 0, 1)
        )));
    }

    @Test
    void theOnlySafe() {
        TheSafestPathInAGrid solution = new TheSafestPathInAGrid();

        assertEquals(1, solution.maximumSafenessFactor(List.of(
                List.of(0, 0, 1),
                List.of(0, 0, 0),
                List.of(0, 0, 0)
        )));
    }

    @Test
    void longSafe() {
        TheSafestPathInAGrid solution = new TheSafestPathInAGrid();

        assertEquals(2, solution.maximumSafenessFactor(List.of(
                List.of(0, 0, 0, 1),
                List.of(0, 0, 0, 0),
                List.of(0, 0, 0, 0),
                List.of(1, 0, 0, 0)
        )));
    }

    @Test
    void loadTest() {
        TheSafestPathInAGrid solution = new TheSafestPathInAGrid();

        assertEquals(198, solution.maximumSafenessFactor(List.of(
                List.of(0, 0, 0, 1),
                List.of(0, 0, 0, 0),
                List.of(0, 0, 0, 0),
                List.of(1, 0, 0, 0)
        )));
    }
}
