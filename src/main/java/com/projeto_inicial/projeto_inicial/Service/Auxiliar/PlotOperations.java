package com.projeto_inicial.projeto_inicial.Service.Auxiliar;

import com.projeto_inicial.projeto_inicial.Exceptions.PlotAreaLessOrEqualZeroInProductionException;
import com.projeto_inicial.projeto_inicial.Model.Plot;
import com.projeto_inicial.projeto_inicial.Model.Production;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class PlotOperations {
    public static BigDecimal totalProduction(Plot plot){
        BigDecimal sum = BigDecimal.ZERO;
        List<Production> pList = plot.getProductionList();
        if(pList != null){
            for (Production p : pList
            ) {
                sum = sum.add(p.getQuantity());
            }
        }
        return sum;
    }

    public static BigDecimal productivity(Plot plot){
        BigDecimal area = plot.getArea();
        if (area.compareTo(BigDecimal.ZERO) <= 0){
            throw new PlotAreaLessOrEqualZeroInProductionException();
        }
        return totalProduction(plot).divide(plot.getArea(), 2, RoundingMode.HALF_UP);
    }

    public static BigDecimal productivityOfList(List<Plot> plotList){
        BigDecimal area = BigDecimal.ZERO;
        BigDecimal production = BigDecimal.ZERO;
        for (Plot p : plotList
        ) {
            area = area.add(p.getArea());
            production = production.add(PlotOperations.totalProduction(p));
        }

        if (area.compareTo(BigDecimal.ZERO) <= 0){
            throw new PlotAreaLessOrEqualZeroInProductionException();
        }
        return production.divide(area, 2, RoundingMode.HALF_UP);
    }
}
