package com.projeto_inicial.projeto_inicial.Service;

import com.projeto_inicial.projeto_inicial.Exceptions.ObjectIncompleteException;
import com.projeto_inicial.projeto_inicial.Exceptions.ObjectNotFoundException;
import com.projeto_inicial.projeto_inicial.Model.Farm;
import com.projeto_inicial.projeto_inicial.Model.Plot;
import com.projeto_inicial.projeto_inicial.Repository.FarmRepository;
import com.projeto_inicial.projeto_inicial.Repository.PlotRepository;
import com.projeto_inicial.projeto_inicial.Service.Auxiliar.CheckFarm;
import com.projeto_inicial.projeto_inicial.Service.Auxiliar.PlotOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class FarmServiceImpl implements FarmService {
    @Autowired
    private FarmRepository farmRepository;
    @Autowired
    private PlotRepository plotRepository;

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
            if(farmId == null || farmId.isEmpty()){
                throw new ObjectIncompleteException("farm Id");
            }
            return  this.farmRepository.findById(farmId).orElseThrow(
                    () -> new ObjectNotFoundException("Farm", farmId));
        }
        catch(Exception e){
            throw new InternalError(e);
        }
    }

    @Override
    public Farm create(Farm farm){
        try{
            CheckFarm.notNullOrEmpty(farm);
            CheckFarm.hasName(farm);
            farm.setId(null);
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
    public List<Farm> fetchAllByFarmName(String farmName){
        try{
            if(farmName == null){
                throw new ObjectIncompleteException("Farm Name");
            }
            return this.farmRepository.findFarmsByName(farmName);
        }
        catch(Exception e){
            throw new InternalError(e);
        }
    }

    @Override
    public BigDecimal getProductivity(String farmId){
        try {
            if(farmId == null || farmId.isEmpty()){
                throw new ObjectIncompleteException("Farm Id");
            }
            List<Plot> plotList = this.plotRepository.findPlotsByFarm(farmId);
            return PlotOperations.productivityOfList(plotList);
        }
        catch(Exception e){
            throw new InternalError(e);
        }
    }

    @Override
    public Farm update(Farm farm){
        try{
            CheckFarm.notNullOrEmpty(farm);
            CheckFarm.hasName(farm);
            return this.farmRepository.save(farm);
        }
        catch(Exception e){
            throw new InternalError(e);
        }
    }
}
