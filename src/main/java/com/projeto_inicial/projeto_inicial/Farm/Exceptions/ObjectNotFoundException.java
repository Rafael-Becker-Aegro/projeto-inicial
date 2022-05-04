package com.projeto_inicial.projeto_inicial.Farm.Exceptions;

public class ObjectNotFoundException extends RuntimeException{
    public ObjectNotFoundException(String objName, String id) {
        super(objName + " '" + id + "' not found.");
    }
}