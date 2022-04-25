package com.projeto_inicial.projeto_inicial.Repository;

import com.projeto_inicial.projeto_inicial.Model.Talhao;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TalhaoRepository extends MongoRepository<Talhao, String> {
    List<Talhao> findTalhaosByIdFazenda(String idFazenda);
}
