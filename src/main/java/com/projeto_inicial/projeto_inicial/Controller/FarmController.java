package com.projeto_inicial.projeto_inicial.Controller;

import com.projeto_inicial.projeto_inicial.Service.FarmServiceImpl;
import com.projeto_inicial.projeto_inicial.Model.Farm;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Farm> obterTodos(){
        return farmServiceImpl.getAll();
    }

    @GetMapping("/{farmId}")
    public Farm getById(@PathVariable String farmId){
        return this.farmServiceImpl.fetchById(farmId);
    }

    @PostMapping
    public Farm create(@RequestBody Farm farm){
        return this.farmServiceImpl.create(farm);
    }

    @DeleteMapping("/{farmId}")
    public String removeById(@PathVariable String farmId){
        return this.farmServiceImpl.removeById(farmId);
    }

    @GetMapping("/by_name/{farmName}")
    public List<Farm> fetchAllByName(@PathVariable String farmName){
        return farmServiceImpl.fetchAllByFarmName(farmName);
    }
}
