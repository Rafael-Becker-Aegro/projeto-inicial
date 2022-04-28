package com.projeto_inicial.projeto_inicial.Farm.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.ObjectUtils;

import java.util.Objects;

@Document
public class Farm {

    @Id
    private String id;
    @NotNull
    private String name;

    public Farm(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public boolean isComplete(){
        return !(this.isEmpty() || this.id.isEmpty() || this.name.isEmpty());
    }

    @JsonIgnore
    public boolean isEmpty(){
        return ObjectUtils.isEmpty(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Farm farm = (Farm) o;
        return Objects.equals(id, farm.id) && Objects.equals(name, farm.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Farm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
