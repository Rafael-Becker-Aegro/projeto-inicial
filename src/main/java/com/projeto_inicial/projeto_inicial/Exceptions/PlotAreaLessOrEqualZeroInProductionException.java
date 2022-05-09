package com.projeto_inicial.projeto_inicial.Exceptions;

public class PlotAreaLessOrEqualZeroInProductionException extends  RuntimeException{
    public PlotAreaLessOrEqualZeroInProductionException() {
        super("Area can't be zero to calculate productivity");
    }
}
