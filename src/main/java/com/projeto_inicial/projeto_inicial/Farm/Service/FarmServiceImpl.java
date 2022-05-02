package com.projeto_inicial.projeto_inicial.Farm.Service;

import com.projeto_inicial.projeto_inicial.Farm.Exceptions.FarmIncompleteException;
import com.projeto_inicial.projeto_inicial.Farm.Exceptions.FarmNotFoundException;
import com.projeto_inicial.projeto_inicial.Farm.Model.Farm;
import com.projeto_inicial.projeto_inicial.Farm.Repository.FarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmServiceImpl implements FarmService {
    @Autowired
    private FarmRepository farmRepository;

    @Override
    public List<Farm> getAll(){
        try {
            return this.farmRepository.findAll();
        }
        catch(Exception e){
            throw new InternalError(e);
        }
    }

    @Override
    public Farm fetchById(String farmId){
        try {
            if(farmId.isEmpty()){
                throw new FarmIncompleteException("farm Id");
            }
            return  this.farmRepository.findById(farmId).orElseThrow(
                    () -> new FarmNotFoundException(farmId));
        }
        catch(Exception e){
            throw new InternalError(e);
        }
    }

    @Override
    public Farm create(Farm farm){
        try{
            CheckFarm.hasName(farm);
            return this.farmRepository.save(farm);
        }
        catch(Exception e){
            throw new InternalError(e);
        }
    }

    @Override
    public void remove(String farmId){
        try{
            Farm farm = this.fetchById(farmId);

            this.farmRepository.delete(farm);
        }
        catch(Exception e){
            throw new InternalError(e);
        }
    }

    @Override
    public List<Farm> fetchAllByFarmName(java.lang.String farmName){
        try{
            return this.farmRepository.findFarmsByName(farmName);
        }
        catch(Exception e){
            throw new InternalError(e);
        }
    }

}
