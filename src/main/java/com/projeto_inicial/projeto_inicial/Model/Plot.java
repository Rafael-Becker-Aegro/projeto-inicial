package com.projeto_inicial.projeto_inicial.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;
import java.util.List;

@Document
public class Plot {

    @Id
    private String id;
    @NotNull
    private String name;
    @NotNull
    private BigDecimal area;
    @NotNull
    private String farm;

    public Plot(String id, String name, BigDecimal area, String farm) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.farm = farm;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public String getFarm() {
        return farm;
    }

    @JsonIgnore
    public boolean isEmpty(){
        return ObjectUtils.isEmpty(this);
    }

    public void setFarm(String farm) {
        this.farm = farm;
    }

    public void setProductionList(List<Production> productionList) {
    }
}
