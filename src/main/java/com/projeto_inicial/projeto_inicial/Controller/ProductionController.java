package com.projeto_inicial.projeto_inicial.Controller;

import com.projeto_inicial.projeto_inicial.Model.Production;
import com.projeto_inicial.projeto_inicial.Service.ProductionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/farms/{farmId}/plots/{plotId}/productions")
public class ProductionController {

    @Autowired
    private final ProductionServiceImpl productionService;

    public ProductionController(ProductionServiceImpl productionService) {
        this.productionService = productionService;
    }

    @GetMapping
    public ResponseEntity<List<Production>> fetchAllByPlotId(@PathVariable String plotId){
        List<Production> productions = this.productionService.fetchAllByPlotId(plotId);
        return new ResponseEntity<List<Production>>(productions, HttpStatus.OK);
    }

    @GetMapping("/{productionId}")
    public ResponseEntity<Production> fetchById(@PathVariable String productionId){
        Production production = this.productionService.fetchById(productionId);
        return new ResponseEntity<Production>(production, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Production> create(@RequestBody Production production, @PathVariable String plotId, @PathVariable String farmId){
        production.setPlot(plotId);
        production.setFarm(farmId);
        Production addedProduction = this.productionService.create(production);
        return new ResponseEntity<Production>(addedProduction, HttpStatus.CREATED);
    }

    @DeleteMapping("/{productionId}")
    public ResponseEntity<Production> removeById(@PathVariable String productionId){
        this.productionService.removeById(productionId);
        return new ResponseEntity<Production>(HttpStatus.OK);
    }

    @PutMapping("/{productionId}")
    public ResponseEntity<Production> update(@RequestBody Production production, @PathVariable String productionId, @PathVariable String plotId, @PathVariable String farmId){
        production.setId(productionId);
        production.setPlot(plotId);
        production.setFarm(farmId);
        Production updatedProduction = this.productionService.update(production);
        return new ResponseEntity<Production>(updatedProduction, HttpStatus.OK);
    }
}
