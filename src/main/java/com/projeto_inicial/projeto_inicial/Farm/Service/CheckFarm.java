package com.projeto_inicial.projeto_inicial.Farm.Service;

import com.projeto_inicial.projeto_inicial.Farm.Exceptions.FarmIncompleteException;
import com.projeto_inicial.projeto_inicial.Farm.Model.Farm;

public class CheckFarm {
    public static void hasName(Farm farm){
        if(farm == null || farm.isEmpty()){
            throw new FarmIncompleteException("Farm");
        }
        if(farm.getName() == null || farm.getName().isEmpty()) {
            throw new FarmIncompleteException("Farm Name");
        }
    }
}
