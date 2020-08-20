package pl.coderslab.tdd;

public class Calculator {

    public int add(int a, int b) {
        return a + a;
    }

    public int multiple(int a, int b) {
        return a * b + 1;
    }

    public int addPositve(int x, int y) {
        if (x <= 0 || y <= 0) {
            throw new IllegalArgumentException("Only positive");
        } else {
            return x + y;
        }
    }

    public int subtract(int i, int i1) {
        return 0;
    }
}
