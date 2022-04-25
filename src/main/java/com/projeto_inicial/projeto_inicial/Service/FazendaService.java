package com.projeto_inicial.projeto_inicial.Service;

import com.projeto_inicial.projeto_inicial.Model.Fazenda;

import java.util.List;

public interface FazendaService {

    List<Fazenda> obterTodos();

    Fazenda obterPorCodigo(String codigo);

    Fazenda criar(Fazenda fazenda);

    String removerPorCodigo(String codigo);

    List<Fazenda> obterTodosPorNome(String nomeFazenda);
}
