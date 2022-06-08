package com.projeto_inicial.projeto_inicial.Service.Auxiliar;

import com.projeto_inicial.projeto_inicial.Exceptions.ObjectIncompleteException;
import com.projeto_inicial.projeto_inicial.Exceptions.PlotAreaLessOrEqualZeroException;
import com.projeto_inicial.projeto_inicial.Model.Plot;

import java.math.BigDecimal;

public class CheckPlot {
    public static void notNullOrEmpty(Plot plot){
        if(plot == null || plot.isEmpty()){
            throw new ObjectIncompleteException("Plot");
        }
    }

    public static void hasName(Plot plot){
        if(plot.getName() == null || plot.getName().isEmpty()) {
            throw new ObjectIncompleteException("Plot Name");
        }
    }

    public static void hasId(Plot plot){
        if(plot.getId() == null || plot.getId().isEmpty()) {
            throw new ObjectIncompleteException("Plot Id");
        }
    }

    public static void hasValidArea(Plot plot){
        if(plot.getArea() == null) {
            throw new ObjectIncompleteException("Plot Area");
        }
        if(plot.getArea().compareTo(BigDecimal.ZERO) <= 0){
            throw new PlotAreaLessOrEqualZeroException();
        }
    }

    public static void hasFarm(Plot plot){
        if(plot.getFarm() == null || plot.getFarm().isEmpty()) {
            throw new ObjectIncompleteException("Farm id");
        }
    }

    public static void hasProductivity(Plot plot){
        if(plot.getFarm() == null || plot.getFarm().isEmpty()) {
            throw new ObjectIncompleteException("Plot Productivity");
        }
    }

    public static void forInsertion(Plot plot){
        notNullOrEmpty(plot);
        hasName(plot);
        hasValidArea(plot);
        hasFarm(plot);
    }

    public static void forUpdate(Plot plot){
        hasId(plot);
        notNullOrEmpty(plot);
        hasName(plot);
        hasValidArea(plot);
    }
}
