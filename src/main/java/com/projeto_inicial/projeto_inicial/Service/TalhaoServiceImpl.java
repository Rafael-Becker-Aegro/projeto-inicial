package com.projeto_inicial.projeto_inicial.Service;

import com.projeto_inicial.projeto_inicial.Model.Talhao;
import com.projeto_inicial.projeto_inicial.Repository.FazendaRepository;
import com.projeto_inicial.projeto_inicial.Repository.TalhaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TalhaoServiceImpl implements  TalhaoService{
    @Autowired
    private TalhaoRepository talhaoRepository;

    @Autowired
    private FazendaRepository fazendaRepository;

    @Override
    public Talhao obterPorCodigo(String codigo) {
        Optional<Talhao> achaTalhao = this.talhaoRepository.findById(codigo);
        Talhao talhao;
        if(achaTalhao.isPresent()){
            talhao = achaTalhao.get();
        }else{
            throw new RuntimeException("Não foi achado talhao com o id: "+ codigo);
        }
        return talhao;
    }

    @Override
    public Talhao criar(Talhao talhao) {
        return this.talhaoRepository.save(talhao);
    }

    @Override
    public String removerPorCodigo(String codigo) {
        Talhao talhao = this.obterPorCodigo(codigo);
        this.talhaoRepository.delete(talhao);
        return "Talhao " + codigo + " deletado com sucesso.";
    }

    @Override
    public List<Talhao> obterTodosPorIdFazenda(String idFazenda) {
        return this.talhaoRepository.findTalhaosByIdFazenda(idFazenda);
    }

    private void fazendaExiste(String idFazenda){

    }
}
