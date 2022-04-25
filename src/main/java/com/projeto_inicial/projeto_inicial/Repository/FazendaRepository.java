package com.projeto_inicial.projeto_inicial.Repository;

import com.projeto_inicial.projeto_inicial.Model.Fazenda;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FazendaRepository extends MongoRepository<Fazenda, String> {
    List<Fazenda> findFazendasByNome(String nome);
}
