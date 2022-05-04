package com.projeto_inicial.projeto_inicial.Service;

import com.projeto_inicial.projeto_inicial.Exceptions.ObjectIncompleteException;
import com.projeto_inicial.projeto_inicial.Model.Farm;

public class CheckFarm {
    public static void notNullOrEmpty(Farm farm){
        if(farm == null || farm.isEmpty()){
            throw new ObjectIncompleteException("Farm");
        }
    }

    public static void hasName(Farm farm){
        if(farm.getName() == null || farm.getName().isEmpty()) {
            throw new ObjectIncompleteException("Farm Name");
        }
    }

    public static void hasId(Farm farm){
        if(farm.getId() == null || farm.getId().isEmpty()) {
            throw new ObjectIncompleteException("Farm Id");
        }
    }
}
