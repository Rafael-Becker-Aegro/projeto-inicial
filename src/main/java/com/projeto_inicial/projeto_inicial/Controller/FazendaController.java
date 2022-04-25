package com.projeto_inicial.projeto_inicial.Controller;

import com.projeto_inicial.projeto_inicial.Service.FazendaService;
import com.projeto_inicial.projeto_inicial.Model.Fazenda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/fazenda")
public class FazendaController {

    @Autowired
    private final FazendaService fazendaService;

    public FazendaController(FazendaService fazendaService) {
        this.fazendaService = fazendaService;
    }

    @GetMapping
    public List<Fazenda> obterTodos(){
        return fazendaService.obterTodos();
    }

    @GetMapping("/{codigo}")
    public Fazenda obterPorCodigo(@PathVariable String codigo){
        return this.fazendaService.obterPorCodigo(codigo);
    }

    @PostMapping
    public Fazenda criar(@RequestBody Fazenda fazenda){
        return this.fazendaService.criar(fazenda);
    }

    @DeleteMapping("/{codigo}")
    public String removerPorCodigo(@PathVariable String codigo){
        return this.fazendaService.removerPorCodigo(codigo);
    }
}
