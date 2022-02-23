package com.example.springmaventhymeleaftesting;

public class MathOperations {
    public static double reduceDecimals(double value) {
        return Math.round(Math.pow(10.0, 2) * value) / Math.pow(10.0, 2);
    }
}
