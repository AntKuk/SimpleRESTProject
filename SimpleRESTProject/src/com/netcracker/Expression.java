package com.netcracker;

public class Expression {

    private String operation;
    private int a;
    private int b;
    private double result;

    public Expression() {
    }

    public Expression(String operation, int a, int b, double result) {
        this.operation = operation;
        this.a = a;
        this.b = b;
        this.result = result;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return a + operation + b + " = " + result;
    }
}
