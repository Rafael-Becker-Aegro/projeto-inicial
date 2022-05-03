package com.projeto_inicial.projeto_inicial.Farm.Repository;

import com.projeto_inicial.projeto_inicial.Farm.Model.Plot;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PlotRepository extends MongoRepository<Plot, String> {
    List<Plot> findPlotsByFarm(String farm);
}
