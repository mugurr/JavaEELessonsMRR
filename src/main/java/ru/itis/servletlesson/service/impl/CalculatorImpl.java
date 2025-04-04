package ru.itis.servletlesson.service.impl;

import ru.itis.servletlesson.service.Calculator;

public class CalculatorImpl implements Calculator {
    @Override
    public int sum(int a, int b) {
        return a + b;
    }

    @Override
    public int minus(int a, int b) {
        return a - b;
    }

    @Override
    public int multiply(int a, int b) {
        return a * b;
    }

    @Override
    public int divide(int a, int b) {
        return a / b;
    }

    @Override
    public int mod(int a, int b) {
        return 0;
    }
}
