package com.banco.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SampleTest {
    @Test
    public void testSum() {
        int result = 2 + 3;
        assertEquals(5, result);
    }

    @Test
    public void testDifference() {
        int result = 10 - 5;
        assertEquals(5, result);
    }
}
