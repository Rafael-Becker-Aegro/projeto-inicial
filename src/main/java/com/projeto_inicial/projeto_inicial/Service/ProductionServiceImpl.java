package com.projeto_inicial.projeto_inicial.Service;

import com.projeto_inicial.projeto_inicial.Exceptions.CantChangePlotFarmException;
import com.projeto_inicial.projeto_inicial.Exceptions.CantChangeProductionPlotException;
import com.projeto_inicial.projeto_inicial.Exceptions.ObjectIncompleteException;
import com.projeto_inicial.projeto_inicial.Exceptions.ObjectNotFoundException;
import com.projeto_inicial.projeto_inicial.Model.Production;
import com.projeto_inicial.projeto_inicial.Repository.PlotRepository;
import com.projeto_inicial.projeto_inicial.Repository.ProductionRepository;
import com.projeto_inicial.projeto_inicial.Service.Auxiliar.CheckProduction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductionServiceImpl implements ProductionService{
    @Autowired
    private ProductionRepository productionRepository;
    @Autowired
    private PlotRepository plotRepository;

    public ProductionServiceImpl() {
    }

    @Override
    public Production fetchById(String productionId) {
        if(productionId == null || productionId.isEmpty()){
            throw new ObjectIncompleteException("Production Id");
        }
        return  this.productionRepository.findById(productionId).orElseThrow(
                () -> new ObjectNotFoundException("Production", productionId));
    }

    @Override
    public Production create(Production production) {
        CheckProduction.forInsertion(production);
        production.setId(null);
        if(plotRepository.existsById(production.getPlot()))
        {
            return this.productionRepository.save(production);
        }
        throw new ObjectNotFoundException("Plot", production.getPlot());
    }

    @Override
    public void removeById(String productionId) {
        Production production = this.fetchById(productionId);
        this.productionRepository.delete(production);
    }

    @Override
    public List<Production> fetchAllByPlotId(String plotId) {
        if(plotId == null || plotId.isEmpty()){
            throw new ObjectIncompleteException("Plot Id");
        }
        return this.productionRepository.findProductionsByPlot(plotId);
    }

    @Override
    public List<Production> fetchAllByFarmId(String farmId) {
        if(farmId == null || farmId.isEmpty()){
            throw new ObjectIncompleteException("Plot Id");
        }
        return this.productionRepository.findProductionsByFarm(farmId);
    }

    @Override
    public Production update(Production production) {
        CheckProduction.forUpdate(production);
        Production oldProduction = this.fetchById(production.getId());
        if(!production.getPlot().equals(oldProduction.getPlot())){
            throw new CantChangeProductionPlotException();
        }
        if(!production.getFarm().equals(oldProduction.getFarm())){
            throw new CantChangePlotFarmException();
        }
        return this.productionRepository.save(production);
    }

    @Override
    public Long removeAllByPlotId(String plotId){
        if(plotId == null || plotId.isEmpty()){
            throw new ObjectIncompleteException("Plot Id");
        }
        return this.productionRepository.deleteProductionByPlot(plotId);
    }

    @Override
    public Long removeAllByFarmId(String farmId){
        if(farmId == null || farmId.isEmpty()){
            throw new ObjectIncompleteException("Farm Id");
        }
        return this.productionRepository.deleteProductionByFarm(farmId);
    }
}
