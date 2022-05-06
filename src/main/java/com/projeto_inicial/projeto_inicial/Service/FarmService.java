package com.projeto_inicial.projeto_inicial.Service;

import com.projeto_inicial.projeto_inicial.Model.Farm;

import java.math.BigDecimal;
import java.util.List;

public interface FarmService {

    List<Farm> getAll();

    Farm fetchById(String farmId);

    Farm create(Farm farm);

    void remove(String farm);

    List<Farm> fetchAllByFarmName(String farmName);

    BigDecimal getProductivity(String farmId);

    Farm update(Farm farm);
}
