package com.projeto_inicial.projeto_inicial.Fazenda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/fazenda")
public class FazendaController {

    private final FazendaController fazendaController;

    @Autowired
    public FazendaController(FazendaController fazendaController) {
        this.fazendaController = fazendaController;
    }

    @GetMapping
    public List<Fazenda> getFazendas(){
        return fazendaController.getFazendas();
    }
}
