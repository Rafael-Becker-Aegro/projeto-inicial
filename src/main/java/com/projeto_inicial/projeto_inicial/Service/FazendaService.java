package com.projeto_inicial.projeto_inicial.Service;

import com.projeto_inicial.projeto_inicial.Model.Fazenda;
import com.projeto_inicial.projeto_inicial.Repository.FazendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FazendaService {

    @Autowired
    private FazendaRepository fazendaRepository;

    public List<Fazenda> obterTodos(){
        return  this.fazendaRepository.findAll();
    }

    public Fazenda obterPorCodigo(String codigo){
        Optional<Fazenda> achaFazenda = this.fazendaRepository.findById(codigo);
        Fazenda fazenda = null;
        if(achaFazenda.isPresent()){
            fazenda = achaFazenda.get();
        }else{
            throw new RuntimeException("Não foi achada fazenda com o id: "+ codigo);
        }
        return fazenda;
    }

    public Fazenda criar(Fazenda fazenda){
        return this.fazendaRepository.save(fazenda);
    }

    public String removerPorCodigo(String codigo){
        Fazenda fazenda = this.obterPorCodigo(codigo);
        this.fazendaRepository.delete(fazenda);
        return "Fazenda " + codigo + " deletada com sucesso.";
    }
}
