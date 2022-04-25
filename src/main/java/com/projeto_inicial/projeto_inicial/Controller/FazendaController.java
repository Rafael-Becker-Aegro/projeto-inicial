package com.projeto_inicial.projeto_inicial.Controller;

import com.projeto_inicial.projeto_inicial.Service.FazendaServiceImpl;
import com.projeto_inicial.projeto_inicial.Model.Fazenda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/fazenda")
public class FazendaController {

    @Autowired
    private final FazendaServiceImpl fazendaServiceImpl;

    public FazendaController(FazendaServiceImpl fazendaServiceImpl) {
        this.fazendaServiceImpl = fazendaServiceImpl;
    }

    @GetMapping
    public List<Fazenda> obterTodos(){
        return fazendaServiceImpl.obterTodos();
    }

    @GetMapping("/{codigo}")
    public Fazenda obterPorCodigo(@PathVariable String codigo){
        return this.fazendaServiceImpl.obterPorCodigo(codigo);
    }

    @PostMapping
    public Fazenda criar(@RequestBody Fazenda fazenda){
        return this.fazendaServiceImpl.criar(fazenda);
    }

    @DeleteMapping("/{codigo}")
    public String removerPorCodigo(@PathVariable String codigo){
        return this.fazendaServiceImpl.removerPorCodigo(codigo);
    }

    @GetMapping("/por_nome/{nomeFazenda}")
    public List<Fazenda> obterTodosPorNome(@PathVariable String nomeFazenda){
        return fazendaServiceImpl.obterTodosPorNome(nomeFazenda);
    }
}
