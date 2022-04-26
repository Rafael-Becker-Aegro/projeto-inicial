package com.projeto_inicial.projeto_inicial.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Plot {

    @Id
    private String id;
    private String name;
    private int area;

    @DBRef
    private String farm;

    public Plot(String name, int area, String farm) {
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

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
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
