package com.projeto_inicial.projeto_inicial.Farm.Repository;

import com.projeto_inicial.projeto_inicial.Farm.Model.Farm;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FarmRepository extends MongoRepository<Farm, String> {
    List<Farm> findFarmsByName(String name);
}