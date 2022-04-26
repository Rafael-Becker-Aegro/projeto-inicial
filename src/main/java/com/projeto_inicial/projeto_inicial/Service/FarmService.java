package com.projeto_inicial.projeto_inicial.Service;

import com.projeto_inicial.projeto_inicial.Model.Farm;

import java.util.List;

public interface FarmService {

    List<Farm> getAll();

    Farm fetchById(String farmId);

    Farm create(Farm farm);

    String removeById(String farmId);

    List<Farm> fetchAllByFarmName(String farmName);
}
