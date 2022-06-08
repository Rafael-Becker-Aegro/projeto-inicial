package com.projeto_inicial.projeto_inicial.Service.Auxiliar;

import com.projeto_inicial.projeto_inicial.Model.Plot;
import com.projeto_inicial.projeto_inicial.Model.Production;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class ProductivityOperations {
    public static BigDecimal totalProduction(List<Production> productionList) {
        BigDecimal sum = BigDecimal.ZERO;
        if (productionList != null) {
            for (Production p : productionList
            ) {
                sum = sum.add(p.getQuantity());
            }
        }
        return sum;
    }

    public static BigDecimal productivityOfList(List<Plot> plotList, List<Production> productionList) {
        BigDecimal totalArea = BigDecimal.ZERO;
        for (Plot p : plotList
        ) {
            totalArea = totalArea.add(p.getArea());
        }
        if (totalArea.compareTo(BigDecimal.ZERO) <= 0) {
            return BigDecimal.ZERO;
        }
        return totalProduction(productionList).divide(totalArea, 2, RoundingMode.HALF_UP);
    }

    public static BigDecimal calculatePlotProductivity(BigDecimal area, List<Production> productionList) {
        if (area.compareTo(BigDecimal.ZERO) <= 0) {
            return BigDecimal.ZERO;
        }
        return totalProduction(productionList).divide(area, 2, RoundingMode.HALF_UP);
    }
}
