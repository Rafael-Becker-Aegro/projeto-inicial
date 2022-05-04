package com.projeto_inicial.projeto_inicial.Exceptions;

public class ObjectIncompleteException extends  RuntimeException{
    public ObjectIncompleteException(String missingInfo) {
        super("Missing " + missingInfo + ".");
    }
}
