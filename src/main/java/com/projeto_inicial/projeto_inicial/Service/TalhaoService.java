package com.projeto_inicial.projeto_inicial.Service;

import com.projeto_inicial.projeto_inicial.Model.Talhao;

import java.util.List;

public interface TalhaoService {
    Talhao obterPorCodigo(String codigo);

    Talhao criar(Talhao talhao);

    String removerPorCodigo(String codigo);

    List<Talhao> obterTodosPorIdFazenda(String idFazenda);
}
