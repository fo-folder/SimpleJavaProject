package com.farida.operations;

public abstract class Operation {
    protected long aLeft;
    protected long bRight;

    public void addLeft(long a) {
        aLeft = a;
    }
    public void addRight(long b) {
        bRight = b;
    }
    public abstract long perform();

}