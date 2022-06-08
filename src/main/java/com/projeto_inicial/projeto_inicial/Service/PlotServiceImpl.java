package com.projeto_inicial.projeto_inicial.Service;

import com.projeto_inicial.projeto_inicial.Exceptions.CantChangePlotFarmException;
import com.projeto_inicial.projeto_inicial.Exceptions.ObjectIncompleteException;
import com.projeto_inicial.projeto_inicial.Exceptions.ObjectNotFoundException;
import com.projeto_inicial.projeto_inicial.Model.Plot;
import com.projeto_inicial.projeto_inicial.Model.Production;
import com.projeto_inicial.projeto_inicial.Repository.FarmRepository;
import com.projeto_inicial.projeto_inicial.Repository.PlotRepository;
import com.projeto_inicial.projeto_inicial.Service.Auxiliar.CheckPlot;
import com.projeto_inicial.projeto_inicial.Service.Auxiliar.ProductivityOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PlotServiceImpl implements PlotService {
    @Autowired
    private ProductionServiceImpl productionService;
    @Autowired
    private PlotRepository plotRepository;
    @Autowired
    private FarmRepository farmRepository;

    @Override
    public Plot fetchById(String plotId) {
        if (plotId == null || plotId.isEmpty()) {
            throw new ObjectIncompleteException("Plot Id");
        }
        return this.plotRepository.findById(plotId).orElseThrow(
                () -> new ObjectNotFoundException("Plot", plotId));
    }

    @Override
    public Plot create(Plot plot) {
        CheckPlot.forInsertion(plot);
        plot.setId(null);
        if (farmRepository.existsById(plot.getFarm())) {
            return this.plotRepository.save(plot);
        }
        throw new ObjectNotFoundException("Farm", plot.getFarm());
    }

    @Override
    public void removeById(String plotId) {
        Plot plot = this.fetchById(plotId);
        productionService.removeAllByPlotId(plotId);
        this.plotRepository.delete(plot);
    }

    @Override
    public List<Plot> fetchAllByFarmId(String farmId) {
        if (farmId == null || farmId.isEmpty()) {
            throw new ObjectIncompleteException("Farm Id");
        }
        return this.plotRepository.findPlotsByFarm(farmId);
    }

    @Override
    public Plot update(Plot plot) {
        CheckPlot.forUpdate(plot);
        Plot oldPlot = this.fetchById(plot.getId());
        if (!plot.getFarm().equals(oldPlot.getFarm())) {
            throw new CantChangePlotFarmException();
        }
        return this.plotRepository.save(plot);
    }

    @Override
    public BigDecimal getProductivity(String plotId) {
        Plot plot = this.fetchById(plotId);
        List<Production> productionList = this.productionService.fetchAllByPlotId(plotId);

        return ProductivityOperations.calculatePlotProductivity(plot.getArea(), productionList);
    }

    @Override
    public Long removeAllByFarmId(String farmId) {
        if (farmId == null || farmId.isEmpty()) {
            throw new ObjectIncompleteException("Farm Id");
        }
        this.productionService.removeAllByFarmId(farmId);
        return this.plotRepository.deletePlotByFarm(farmId);
    }
}
