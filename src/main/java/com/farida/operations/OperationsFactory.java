package com.farida.operations;

public class OperationsFactory {

    private final static int OPERATION_TYPE_SUM = 1;

    public static VarKeep create(int operationType) {
        if (operationType == OPERATION_TYPE_SUM) {
            return new Summarize();
        } else if (operationType == 2) {
            return new Subtraction();
        } else if (operationType == 3) {
            return new Multipl();
        } else if (operationType == 4) {
            return new Division();
        } else {
            throw new RuntimeException("Unsupported operation type!");
        }
    }
}
