package com.farida.operations;
public class Sum extends VarKeep {

    @Override
    public long perform() {
        return aLeft + bRight;
    }

    private static class Summer {// class for checking getters and setters change

    }
    // Getter
  public Summer getSummer() {
        return new Summer();
  }

  // Setter
  public void setSummer(Summer S) {
        new Summer();
    }
}
