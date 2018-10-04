package com.java.example;

interface Formula extends FormulaA, FormulaB {
    double calculate(int a, int b);

    // has to be override
    @Override
    default double sqrt(int a) {
        return Math.sqrt(a);
    }

}
