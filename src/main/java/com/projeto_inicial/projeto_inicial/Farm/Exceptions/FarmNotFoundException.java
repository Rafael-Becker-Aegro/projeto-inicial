package com.projeto_inicial.projeto_inicial.Farm.Exceptions;

public class FarmNotFoundException extends RuntimeException{
    public FarmNotFoundException(String id) {
        super("Farm '" + id + "' not found.");
    }
}