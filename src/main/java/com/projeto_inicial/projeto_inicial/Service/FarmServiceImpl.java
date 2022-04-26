package com.projeto_inicial.projeto_inicial.Service;

import com.projeto_inicial.projeto_inicial.Model.Farm;
import com.projeto_inicial.projeto_inicial.Repository.FarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FarmServiceImpl implements FarmService {
    @Autowired
    private FarmRepository farmRepository;

    @Override
    public List<Farm> getAll(){
        return  this.farmRepository.findAll();
    }

    @Override
    public Farm fetchById(String farmId){
        Optional<Farm> findFarm = this.farmRepository.findById(farmId);
        Farm farm;
        if(findFarm.isPresent()){
            farm = findFarm.get();
        }else{
            throw new RuntimeException("Couldn't find farm with id: "+ farmId);
        }
        return farm;
    }

    @Override
    public Farm create(Farm farm){
        return this.farmRepository.save(farm);
    }

    @Override
    public String removeById(String farmId){
        Farm farm = this.fetchById(farmId);
        this.farmRepository.delete(farm);
        return "Fazenda " + farmId + " deletada com sucesso.";
    }

    @Override
    public List<Farm> fetchAllByFarmName(String farmName) {
        return this.farmRepository.findFarmsByName(farmName);
    }
}
