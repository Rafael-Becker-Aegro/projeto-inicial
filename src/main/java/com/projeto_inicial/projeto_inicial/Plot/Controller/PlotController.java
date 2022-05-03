package com.projeto_inicial.projeto_inicial.Plot.Controller;

import com.projeto_inicial.projeto_inicial.Plot.Model.Plot;
import com.projeto_inicial.projeto_inicial.Plot.Service.PlotServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/farms/{farmId}/plots")
public class PlotController {

    @Autowired
    private final PlotServiceImpl plotService;

    public PlotController(PlotServiceImpl plotService) {
        this.plotService = plotService;
    }

    @GetMapping
    public ResponseEntity<List<Plot>> fetchAllByFarmId(@PathVariable String farmId){
        List<Plot> plots = this.plotService.fetchAllByFarmId(farmId);
        return new ResponseEntity<List<Plot>>(plots, HttpStatus.OK);
    }

    @GetMapping("/{plotId}")
    public ResponseEntity<Plot> fetchById(@PathVariable String plotId){
        Plot plot = this.plotService.fetchById(plotId);
        return new ResponseEntity<Plot>(plot, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Plot> create(@RequestBody Plot plot, @PathVariable String farmId){
        plot.setFarm(farmId);
        Plot adddedPlot = this.plotService.create(plot);
        return new ResponseEntity<Plot>(adddedPlot, HttpStatus.OK);
    }

    @DeleteMapping("/{plotId}")
    public ResponseEntity<Plot> removeById(@PathVariable String plotId){
        this.plotService.removeById(plotId);
        return new ResponseEntity<Plot>(HttpStatus.OK);

    }
}
