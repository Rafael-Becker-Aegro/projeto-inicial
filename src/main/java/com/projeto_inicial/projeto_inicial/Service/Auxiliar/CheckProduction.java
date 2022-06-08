package com.projeto_inicial.projeto_inicial.Service.Auxiliar;

import com.projeto_inicial.projeto_inicial.Exceptions.ObjectIncompleteException;
import com.projeto_inicial.projeto_inicial.Model.Production;

public class CheckProduction {
    public static void notNullOrEmpty(Production production){
        if(production == null || production.isEmpty()){
            throw new ObjectIncompleteException("Production");
        }
    }

    public static void hasCrop(Production production){
        if(production.getCrop() == null || production.getCrop().isEmpty()) {
            throw new ObjectIncompleteException("Production Crop");
        }
    }

    public static void hasId(Production production){
        if(production.getId() == null || production.getId().isEmpty()) {
            throw new ObjectIncompleteException("Production Id");
        }
    }

    public static void hasQuantity(Production production){
        if(production.getQuantity() == null) {
            throw new ObjectIncompleteException("Production Quantity");
        }
    }

    public static void hasPlot(Production production){
        if(production.getPlot() == null || production.getPlot().isEmpty()) {
            throw new ObjectIncompleteException("Plot id");
        }
    }

    public static void forInsertion(Production production){
        notNullOrEmpty(production);
        hasCrop(production);
        hasPlot(production);
    }

    public static void forUpdate(Production production){
        hasId(production);
        notNullOrEmpty(production);
        hasCrop(production);
        hasPlot(production);
    }
}
