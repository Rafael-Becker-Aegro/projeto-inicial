package com.projeto_inicial.projeto_inicial.Controller;

import com.projeto_inicial.projeto_inicial.Model.Talhao;
import com.projeto_inicial.projeto_inicial.Service.TalhaoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/{idFazenda}")
public class TalhaoController {

    @Autowired
    private final TalhaoServiceImpl talhaoServiceImpl;


    public TalhaoController(TalhaoServiceImpl talhaoServiceImpl) {
        this.talhaoServiceImpl = talhaoServiceImpl;
    }

    @GetMapping
    public List<Talhao> obterTodosPorIdFazenda(@PathVariable String idFazenda){
        return this.talhaoServiceImpl.obterTodosPorIdFazenda(idFazenda);
    }

    @PostMapping
    public Talhao criar(@RequestBody Talhao talhao, @PathVariable String idFazenda){
        talhao.setIdFazenda(idFazenda);
        return this.talhaoServiceImpl.criar(talhao);
    }
}
