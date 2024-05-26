package io.ysb.fizzbuzz.balancedbraces;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BalancedBracesTest {

    @Test
    void noBracesTextIsBalanced() {
        var text = "";

        BalancedBraces balancedBraces = new BalancedBraces();

        assertTrue(balancedBraces.isBalanced(text));
    }
}
