package com.projeto_inicial.projeto_inicial.Service;

import com.projeto_inicial.projeto_inicial.Exceptions.CantChangePlotFarmException;
import com.projeto_inicial.projeto_inicial.Exceptions.ObjectIncompleteException;
import com.projeto_inicial.projeto_inicial.Exceptions.ObjectNotFoundException;
import com.projeto_inicial.projeto_inicial.Model.Plot;
import com.projeto_inicial.projeto_inicial.Repository.FarmRepository;
import com.projeto_inicial.projeto_inicial.Repository.PlotRepository;
import com.projeto_inicial.projeto_inicial.Service.Auxiliar.CheckPlot;
import com.projeto_inicial.projeto_inicial.Service.Auxiliar.PlotOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
            CheckPlot.forInsertion(plot);
            plot.setId(null);
            if(farmRepository.existsById(plot.getFarm()))
            {
                return this.plotRepository.save(plot);
            }
            throw new ObjectNotFoundException("Farm", plot.getFarm());
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

    @Override
    public Plot update(Plot plot){
        try{
            CheckPlot.forUpdate(plot);
            Plot oldPlot = this.fetchById(plot.getId());
            if(!plot.getFarm().equals(oldPlot.getFarm())){
                throw new CantChangePlotFarmException();
            }
            return this.plotRepository.save(plot);
        }
        catch(Exception e){
            throw new InternalError(e);
        }
    }

    @Override
    public BigDecimal getProductivity(String plotId){
        try {
            Plot plot = this.fetchById(plotId);

            return PlotOperations.productivity(plot);
        }
        catch(Exception e){
            throw new InternalError(e);
        }
    }
}
