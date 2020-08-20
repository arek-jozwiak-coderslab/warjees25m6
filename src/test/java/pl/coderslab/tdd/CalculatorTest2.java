package pl.coderslab.tdd;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest2 {

    @Test
    public void multipleTest() {
        Calculator calculator = new Calculator();
        assertEquals(63, calculator.multiple(7, 9));
    }
}
