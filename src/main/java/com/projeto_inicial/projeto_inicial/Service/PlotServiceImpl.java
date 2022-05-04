package com.projeto_inicial.projeto_inicial.Service;

import com.projeto_inicial.projeto_inicial.Exceptions.ObjectIncompleteException;
import com.projeto_inicial.projeto_inicial.Exceptions.ObjectNotFoundException;
import com.projeto_inicial.projeto_inicial.Model.Plot;
import com.projeto_inicial.projeto_inicial.Repository.FarmRepository;
import com.projeto_inicial.projeto_inicial.Repository.PlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlotServiceImpl implements PlotService {
    @Autowired
    private PlotRepository plotRepository;

    @Autowired
    private FarmRepository farmRepository;

    @Override
    public Plot fetchById(String plotId) {
        try {
            if(plotId == null || plotId.isEmpty()){
                throw new ObjectIncompleteException("Plot Id");
            }
            return  this.plotRepository.findById(plotId).orElseThrow(
                    () -> new ObjectNotFoundException("Plot", plotId));
        }
        catch(Exception e){
            throw new InternalError(e);
        }
    }

    @Override
    public Plot create(Plot plot) {
        try{
            CheckPlot.hasAllMinusId(plot);
            checkIfFarmExists(plot.getFarm());
            return this.plotRepository.save(plot);
        }
        catch(Exception e){
            throw new InternalError(e);
        }
    }

    @Override
    public void removeById(String plotId) {
        try {
            Plot plot = this.fetchById(plotId);

            this.plotRepository.delete(plot);
        }
        catch(Exception e){
            throw new InternalError(e);
        }
    }

    @Override
    public List<Plot> fetchAllByFarmId(String farmId) {
        try{
            if(farmId == null || farmId.isEmpty()){
                throw new ObjectIncompleteException("Farm Id");
            }
            return this.plotRepository.findPlotsByFarm(farmId);
        }
        catch(Exception e){
            throw new InternalError(e);
        }
    }

    private void checkIfFarmExists(String farmId){
        if(farmId == null || farmId.isEmpty()){
            throw new ObjectIncompleteException("Farm Id");
        }
        this.farmRepository.findById(farmId).orElseThrow(
                () -> new ObjectNotFoundException("Farm", farmId));
    }
}
