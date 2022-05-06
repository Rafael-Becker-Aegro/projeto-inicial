package com.projeto_inicial.projeto_inicial.Service;

import com.projeto_inicial.projeto_inicial.Model.Plot;

import java.math.BigDecimal;
import java.util.List;

public interface PlotService {
    Plot fetchById(String plotId);

    Plot create(Plot plot);

    void removeById(String plotId);

    List<Plot> fetchAllByFarmId(String farmId);

    Plot update(Plot plot);

    BigDecimal getProductivity(String plotId);
}
