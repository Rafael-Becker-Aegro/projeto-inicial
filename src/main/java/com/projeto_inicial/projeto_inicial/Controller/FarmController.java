package com.projeto_inicial.projeto_inicial.Controller;

import com.projeto_inicial.projeto_inicial.Model.Farm;
import com.projeto_inicial.projeto_inicial.Service.FarmServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/farms")
public class FarmController {

    @Autowired
    private final FarmServiceImpl farmServiceImpl;

    public FarmController(FarmServiceImpl farmServiceImpl) {
        this.farmServiceImpl = farmServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<Farm>> getAll(){
        List<Farm> farms = farmServiceImpl.getAll();
        return new ResponseEntity<>(farms, HttpStatus.OK);
    }

    @GetMapping("/{farmId}")
    public ResponseEntity<Farm> fetchById(@PathVariable String farmId){
        Farm farm = this.farmServiceImpl.fetchById(farmId);
        return new ResponseEntity<>(farm, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Farm>  create(@RequestBody Farm farm){
        Farm addedFarm = this.farmServiceImpl.create(farm);
        return new ResponseEntity<>(addedFarm, HttpStatus.CREATED);
    }

    @DeleteMapping("/{farmId}")
    public ResponseEntity<Farm> removeById(@PathVariable String farmId){
        farmServiceImpl.remove(farmId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/by_name/{farmName}")
    public ResponseEntity<List<Farm>> fetchAllByName(@PathVariable String farmName){
        List<Farm> farms = farmServiceImpl.fetchAllByFarmName(farmName);
        return new ResponseEntity<>(farms, HttpStatus.OK);
    }

    @GetMapping("/{farmId}/get_productivity")
    public ResponseEntity<BigDecimal> getProductivity(@PathVariable String farmId){
        BigDecimal productivity = this.farmServiceImpl.getProductivity(farmId);
        return new ResponseEntity<>(productivity, HttpStatus.OK);
    }

    @PutMapping("/{farmId}")
    public ResponseEntity<Farm>  update(@RequestBody Farm farm, @PathVariable String farmId){
        farm.setId(farmId);
        Farm updatedFarm = this.farmServiceImpl.update(farm);
        return new ResponseEntity<>(updatedFarm, HttpStatus.OK);
    }
}
