package com.projeto_inicial.projeto_inicial.Model;

import com.sun.istack.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

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

    public Plot(String name, BigDecimal area, String farm) {
        this.name = name;
        this.area = area;
        this.farm = farm;
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

    public void setFarm(String farm) {
        this.farm = farm;
    }

    @Override
    public String toString() {
        return "Plot{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", area=" + area +
                ", farmId='" + farm + '\'' +
                '}';
    }
}
