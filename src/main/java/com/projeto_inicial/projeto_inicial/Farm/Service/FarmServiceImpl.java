package com.projeto_inicial.projeto_inicial.Farm.Service;

import com.projeto_inicial.projeto_inicial.Farm.Model.Farm;
import com.projeto_inicial.projeto_inicial.Farm.Repository.FarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmServiceImpl implements FarmService {
    @Autowired
    private FarmRepository farmRepository;

    @Override
    public List<Farm> getAll() throws DataAccessException {
        try {
            return this.farmRepository.findAll();
        }
        catch(Exception e){
            return null;
        }
    }

    @Override
    public Farm fetchById(String farmId) throws DataAccessException{
        try {
            return this.farmRepository.findById(farmId).get();
        }
        catch(Exception e){
            return null;
        }
    }

    @Override
    public Farm create(Farm farm) throws DataAccessException{
        try{
        return this.farmRepository.save(farm);
        }
        catch(Exception e){
            return null;
        }
    }

    @Override
    public void remove(Farm farm) throws DataAccessException{
        try{
        this.farmRepository.delete(farm);
        }
        catch(Exception e){
        }
    }

    @Override
    public List<Farm> fetchAllByFarmName(String farmName) throws DataAccessException{
        try{
            return this.farmRepository.findFarmsByName(farmName);
        }
        catch(Exception e){
            return null;
        }
    }

}
