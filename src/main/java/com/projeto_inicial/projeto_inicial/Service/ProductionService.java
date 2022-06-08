package com.projeto_inicial.projeto_inicial.Service;

import com.projeto_inicial.projeto_inicial.Model.Production;

import java.util.List;

public interface ProductionService {
    Production fetchById(String productionId);

    Production create(Production production);

    void removeById(String productionId);

    List<Production> fetchAllByPlotId(String plotId);

    List<Production> fetchAllByFarmId(String plotId);

    Production update(Production production);

    public Long removeAllByPlotId(String plotId);

    public Long removeAllByFarmId(String farmId);
}
