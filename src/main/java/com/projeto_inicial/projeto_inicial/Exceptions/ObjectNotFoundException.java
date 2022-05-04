package com.projeto_inicial.projeto_inicial.Exceptions;

public class ObjectNotFoundException extends RuntimeException{
    public ObjectNotFoundException(String objName, String id) {
        super(objName + " '" + id + "' not found.");
    }
}