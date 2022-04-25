package com.projeto_inicial.projeto_inicial.Service;

import com.projeto_inicial.projeto_inicial.Model.Fazenda;
import com.projeto_inicial.projeto_inicial.Repository.FazendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FazendaServiceImpl implements  FazendaService{
    @Autowired
    private FazendaRepository fazendaRepository;

    @Override
    public List<Fazenda> obterTodos(){
        return  this.fazendaRepository.findAll();
    }

    @Override
    public Fazenda obterPorCodigo(String codigo){
        Optional<Fazenda> achaFazenda = this.fazendaRepository.findById(codigo);
        Fazenda fazenda;
        if(achaFazenda.isPresent()){
            fazenda = achaFazenda.get();
        }else{
            throw new RuntimeException("Não foi achada fazenda com o id: "+ codigo);
        }
        return fazenda;
    }

    @Override
    public Fazenda criar(Fazenda fazenda){
        return this.fazendaRepository.save(fazenda);
    }

    @Override
    public String removerPorCodigo(String codigo){
        Fazenda fazenda = this.obterPorCodigo(codigo);
        this.fazendaRepository.delete(fazenda);
        return "Fazenda " + codigo + " deletada com sucesso.";
    }

    @Override
    public List<Fazenda> obterTodosPorNome(String nomeFazenda) {
        return this.fazendaRepository.findFazendasByNome(nomeFazenda);
    }
}
