package com.projeto_inicial.projeto_inicial.Controller;

import com.projeto_inicial.projeto_inicial.Model.Farm;
import com.projeto_inicial.projeto_inicial.Service.FarmServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/farm")
public class FarmController {

    @Autowired
    private final FarmServiceImpl farmServiceImpl;

    public FarmController(FarmServiceImpl farmServiceImpl) {
        this.farmServiceImpl = farmServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<Farm>> getAll(){
        List<Farm> farms = farmServiceImpl.getAll();
        return new ResponseEntity<List<Farm>>(farms, HttpStatus.OK);
    }

    @GetMapping("/{farmId}")
    public ResponseEntity<Farm> fetchById(@PathVariable String farmId){
        if(farmId.isEmpty()){
            return new ResponseEntity<Farm>(HttpStatus.BAD_REQUEST);
        }
        Farm farm = this.farmServiceImpl.fetchById(farmId);
        if(farm == null || farm.isEmpty()){
            return new ResponseEntity<Farm>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Farm>(farm, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Farm>  create(@RequestBody Farm farm){
        if(!farm.isComplete()){
            return new ResponseEntity<Farm>(HttpStatus.BAD_REQUEST);
        }
        if(farmServiceImpl.fetchById(farm.getId()) != null){
            return new ResponseEntity<Farm>(HttpStatus.BAD_REQUEST);
        }
        Farm addedFarm = this.farmServiceImpl.create(farm);
        return new ResponseEntity<Farm>(addedFarm, HttpStatus.CREATED);
    }

    @DeleteMapping("/{farmId}")
    public ResponseEntity<Farm> removeById(@PathVariable String farmId){
        Farm farm = this.farmServiceImpl.fetchById(farmId);
        if(farm == null || farm.isEmpty()){
            return new ResponseEntity<Farm>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Farm>(farm, HttpStatus.OK);
    }

    @GetMapping("/by_name/{farmName}")
    public ResponseEntity<List<Farm>> fetchAllByName(@PathVariable String farmName){
        List<Farm> farms = farmServiceImpl.fetchAllByFarmName(farmName);
        return new ResponseEntity<List<Farm>>(farms, HttpStatus.OK);
    }
}
