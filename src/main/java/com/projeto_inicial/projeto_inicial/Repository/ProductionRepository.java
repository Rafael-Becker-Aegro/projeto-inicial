package com.projeto_inicial.projeto_inicial.Repository;

import com.projeto_inicial.projeto_inicial.Model.Production;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductionRepository extends MongoRepository<Production, String> {
    List<Production> findProductionsByPlot(String plotId);
}
