package com.projeto_inicial.projeto_inicial.Farm.Service;

import com.projeto_inicial.projeto_inicial.Farm.Repository.PlotRepository;
import com.projeto_inicial.projeto_inicial.Farm.Model.Plot;
import com.projeto_inicial.projeto_inicial.Farm.Repository.FarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlotServiceImpl implements PlotService {
    @Autowired
    private PlotRepository plotRepository;

    @Autowired
    private FarmRepository farmRepository;

    @Override
    public Plot fetchById(String plotId) {
        try {
            Optional<Plot> findPlot = this.plotRepository.findById(plotId);
            Plot plot;
            if(findPlot.isPresent()){
                plot = findPlot.get();
            }else{
                throw new RuntimeException("Couldn't find farm with id: "+ plotId);
            }
            return plot;
        }
        catch(Exception e){
            throw new InternalError(e);
        }
    }

    @Override
    public Plot create(Plot plot) {
        try{
            return this.plotRepository.save(plot);
        }
        catch(Exception e){
            throw new InternalError(e);
        }
    }

    @Override
    public String removeById(String plotId) {
        try {
            Plot plot = this.fetchById(plotId);
            this.plotRepository.delete(plot);
            return "Plot " + plotId + " successfully.";
        }
        catch(Exception e){
            throw new InternalError(e);
        }
    }

    @Override
    public List<Plot> fetchAllByFarmId(String farmId) {
        try{
            return this.plotRepository.findPlotsByFarm(farmId);
        }
        catch(Exception e){
            throw new InternalError(e);
        }
    }

/*    private void fazendaExiste(String idFazenda){

    }*/
}
