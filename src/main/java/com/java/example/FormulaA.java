package com.java.example;

interface FormulaA {
    double calculate(int a, int b);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
