package com.projeto_inicial.projeto_inicial.Service;

import com.projeto_inicial.projeto_inicial.Model.Plot;

import java.util.List;

public interface PlotService {
    Plot fetchById(String plotId);

    Plot create(Plot plot);

    String removeById(String plotId);

    List<Plot> fetchAllByFarmId(String farmId);
}
