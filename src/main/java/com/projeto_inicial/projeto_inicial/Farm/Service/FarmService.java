package com.projeto_inicial.projeto_inicial.Farm.Service;

import com.projeto_inicial.projeto_inicial.Farm.Model.Farm;

import java.util.List;

public interface FarmService {

    List<Farm> getAll();

    public Farm fetchById(String farmId);

    Farm create(Farm farm);

    void remove(String farm);

    List<Farm> fetchAllByFarmName(String farmName);
}
