package com.projeto_inicial.projeto_inicial.Fazenda;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class FazendaService {
    public List<Fazenda> getFazendas(){
        return Arrays.asList(new Fazenda(0001, "Fazenda_1"),
                             new Fazenda(0002, "Fazenda_2"));
    }
}
