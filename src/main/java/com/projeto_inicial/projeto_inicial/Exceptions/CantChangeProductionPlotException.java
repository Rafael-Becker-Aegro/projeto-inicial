package com.projeto_inicial.projeto_inicial.Exceptions;

public class CantChangeProductionPlotException extends  RuntimeException{
    public CantChangeProductionPlotException() {
        super("Production cant be reallocated to another plot");
    }
}
