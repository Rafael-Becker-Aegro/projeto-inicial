package com.projeto_inicial.projeto_inicial.Exceptions;

public class PlotAreaLessOrEqualZeroException extends  RuntimeException{
    public PlotAreaLessOrEqualZeroException() {
        super("Plot Area must be greater than zero");
    }
}
