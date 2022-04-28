package com.projeto_inicial.projeto_inicial.Plot.Service;

import com.projeto_inicial.projeto_inicial.Plot.Model.Plot;
import com.projeto_inicial.projeto_inicial.Farm.Repository.FarmRepository;
import com.projeto_inicial.projeto_inicial.Plot.Repository.PlotRepository;
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
        Optional<Plot> findPlot = this.plotRepository.findById(plotId);
        Plot plot;
        if(findPlot.isPresent()){
            plot = findPlot.get();
        }else{
            throw new RuntimeException("Couldn't find farm with id: "+ plotId);
        }
        return plot;
    }

    @Override
    public Plot create(Plot plot) {
        return this.plotRepository.save(plot);
    }

    @Override
    public String removeById(String plotId) {
        Plot plot = this.fetchById(plotId);
        this.plotRepository.delete(plot);
        return "Plot " + plotId + " successfully.";
    }

    @Override
    public List<Plot> fetchAllByFarmId(String farmId) {
        return this.plotRepository.findPlotsByFarm(farmId);
    }

/*    private void fazendaExiste(String idFazenda){

    }*/
}
