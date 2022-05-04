package com.projeto_inicial.projeto_inicial.Farm.Exceptions;

public class FarmIncompleteException extends  RuntimeException{
    public FarmIncompleteException(String missingInfo) {
        super("Missing " + missingInfo + ".");
    }
}
