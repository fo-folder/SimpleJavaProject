package com.farida.operations;

public class Differ extends Operation {

    @Override
    public long perform() {
        return aLeft - bRight;
    }
}
