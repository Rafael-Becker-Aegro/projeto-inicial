package com.projeto_inicial.projeto_inicial.Repository;

import com.projeto_inicial.projeto_inicial.Model.Fazenda;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FazendaRepository extends MongoRepository<Fazenda, String> {
}
