package com.projeto_inicial.projeto_inicial.Exceptions;

public class CantChangePlotFarmException extends  RuntimeException{
    public CantChangePlotFarmException() {
        super("Plot cant be reallocated to another farm");
    }
}
