package pl.coderslab.tdd;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    private final int A = 3;
    private final int B = 4;
    private final int RESULT = 7;

    @Test
    public void subtractTest(){
        Calculator calculator = new Calculator();
        int result = calculator.subtract(10, 5);
        assertEquals(5, result);
    }

    @Test
    public void add() {
        Calculator calculator = new Calculator();
        int add = calculator.add(A, B);
        assertEquals(RESULT, add);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addPositive() {
        Calculator calculator = new Calculator();
        calculator.addPositve(-1, 3);
    }


}
