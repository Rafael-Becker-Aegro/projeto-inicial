package com.projeto_inicial.projeto_inicial.Farm.Exceptions;

public class ObjectIncompleteException extends  RuntimeException{
    public ObjectIncompleteException(String missingInfo) {
        super("Missing " + missingInfo + ".");
    }
}
