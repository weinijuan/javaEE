package edu.whu;

public class Calculator {
    private long n = 0;

    public Calculator(long n) {
        this.n = n;
    }

    public long add(long x) {
        n = n + x;
        return n;
    }

    public long sub(long x) {
        n = n - x;
        return n;
    }

}
