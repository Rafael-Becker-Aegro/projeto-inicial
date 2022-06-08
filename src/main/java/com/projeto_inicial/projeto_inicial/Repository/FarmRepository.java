package com.projeto_inicial.projeto_inicial.Repository;

import com.projeto_inicial.projeto_inicial.Model.Farm;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

//GlebeRepositoryCustom
public interface FarmRepository extends MongoRepository<Farm, java.lang.String> {
    List<Farm> findFarmsByName(java.lang.String name);
}