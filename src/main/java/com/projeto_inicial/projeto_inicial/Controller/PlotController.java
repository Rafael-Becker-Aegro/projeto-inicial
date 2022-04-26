package com.projeto_inicial.projeto_inicial.Controller;

import com.projeto_inicial.projeto_inicial.Model.Plot;
import com.projeto_inicial.projeto_inicial.Service.PlotServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/farm_plots/{farmId}")
public class PlotController {

    @Autowired
    private final PlotServiceImpl talhaoServiceImpl;

    public PlotController(PlotServiceImpl talhaoServiceImpl) {
        this.talhaoServiceImpl = talhaoServiceImpl;
    }

    @GetMapping
    public List<Plot> fetchAllByFarmId(@PathVariable String farmId){
        return this.talhaoServiceImpl.fetchAllByFarmId(farmId);
    }

    @PostMapping
    public Plot create(@RequestBody Plot plot, @PathVariable String farmId){
        plot.setFarm(farmId);
        return this.talhaoServiceImpl.create(plot);
    }

    @GetMapping("/{plotId}")
    public Plot fetchById(@PathVariable String plotId){
        return this.talhaoServiceImpl.fetchById(plotId);
    }

    @DeleteMapping("/{plotId}")
    public String removeById(@PathVariable String plotId){
        return this.talhaoServiceImpl.removeById(plotId);
    }
}
