package com.projeto_inicial.projeto_inicial.Service;

import com.projeto_inicial.projeto_inicial.Model.Farm;

import java.util.List;

public interface FarmService {

    List<Farm> getAll();

    Farm fetchById(String farmId);

    Farm create(Farm farm);

    void remove(Farm farm);

    List<Farm> fetchAllByFarmName(String farmName);
}
