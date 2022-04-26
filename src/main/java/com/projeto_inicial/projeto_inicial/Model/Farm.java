package com.projeto_inicial.projeto_inicial.Model;

import com.sun.istack.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Farm {

    @Id
    private String id;
    @NotNull
    private String name;

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

    public Farm(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Farm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
