package com.projeto_inicial.projeto_inicial.Farm.Service;

import com.projeto_inicial.projeto_inicial.Farm.Model.Plot;

import java.util.List;

public interface PlotService {
    Plot fetchById(String plotId);

    Plot create(Plot plot);

    String removeById(String plotId);

    List<Plot> fetchAllByFarmId(String farmId);
}
