package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    void shouldAdd() {
        assertEquals(5, new Calculator().ADD(2, 3));
    }
}
